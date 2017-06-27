import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class UserPanel extends JPanel{
    private static final long serialVersionUID = -8005126132273764537L;

    private JPanel infoGathererPanel = new JPanel(new BorderLayout()); //панель для кнопок

    private JLabel lblMinSize = new JLabel("Left border of the range"); // Различные лейблы(надписи)
    private JLabel lblMaxSize = new JLabel("Right border of the range");
    private JLabel lblDefis = new JLabel("-");
    private JLabel lblSize = new JLabel("Quantity");

    private JButton loadButton = new JButton("Load"); // Кнопки
    private JButton prevButton = new JButton("Prev");
    private JButton startButton = new JButton("Start");
    private JButton nextButton = new JButton("Next");
    private JButton resultButton = new JButton("Result");


    private JTextField txtFieldMinSize = new JTextField(8); // Поля для ввода текста
    private JTextField txtFieldMaxSize = new JTextField(8);
    private JTextField txtFieldSize = new JTextField(8);

    private Array array;
    private ArrayList<Step> arrayList;
    private int nextPrevIndex;


    public UserPanel() {

        lblMinSize.setFont(new Font("Arial",Font.BOLD,12)); // редактирует шрифты
        lblMaxSize.setFont(new Font("Arial",Font.BOLD,12));
        lblDefis.setFont(new Font("Arial",0,20));
        lblSize.setFont(new Font("Arial",Font.BOLD,12));

        txtFieldMinSize.setHorizontalAlignment(JTextField.CENTER);
        txtFieldMaxSize.setHorizontalAlignment(JTextField.CENTER);
        txtFieldSize.setHorizontalAlignment(JTextField.CENTER);

        prevButton.setEnabled(false); //выключает кнопки, чтобы юзер не мог их активировать до загрузки данных
        nextButton.setEnabled(false);
        startButton.setEnabled(false);
        resultButton.setEnabled(false);

        Box startResultBox = Box.createHorizontalBox();
        Box prevNextBox = Box.createHorizontalBox();
        Box infoGathererBox = Box.createHorizontalBox();
        Box labelBox = Box.createHorizontalBox();
        Box infoLabelBox = Box.createVerticalBox();
        Box infoLabelLoadBox =Box.createHorizontalBox();
        Box userPanelBox = Box.createHorizontalBox();

        startResultBox.add(startButton);
        startResultBox.add(Box.createHorizontalStrut(40));
        startResultBox.add(resultButton);

        prevNextBox.add(prevButton);
        prevNextBox.add(Box.createHorizontalStrut(10));
        prevNextBox.add(nextButton);

        infoGathererBox.add(txtFieldMinSize);
        infoGathererBox.add(Box.createHorizontalStrut(2));
        infoGathererBox.add(lblDefis);
        infoGathererBox.add(Box.createHorizontalStrut(4));
        infoGathererBox.add(txtFieldMaxSize);
        infoGathererBox.add(Box.createHorizontalStrut(20));
        infoGathererBox.add(txtFieldSize);

        labelBox.add(lblMinSize);
        labelBox.add(Box.createHorizontalStrut(25));
        labelBox.add(lblMaxSize);
        labelBox.add(Box.createHorizontalStrut(79));
        labelBox.add(lblSize);
        labelBox.add(Box.createHorizontalStrut(44));

        infoLabelBox.add(Box.createVerticalStrut(10));
        infoLabelBox.add(labelBox);
        infoLabelBox.add(Box.createVerticalStrut(2));
        infoLabelBox.add(infoGathererBox);
        infoLabelBox.add(Box.createVerticalStrut(20));

        infoLabelLoadBox.add(infoLabelBox);
        infoLabelLoadBox.add(Box.createHorizontalStrut(10));
        infoLabelLoadBox.add(loadButton);

        userPanelBox.add(Box.createHorizontalStrut(10));
        userPanelBox.add(infoLabelLoadBox);
        userPanelBox.add(Box.createHorizontalStrut(40));
        userPanelBox.add(prevNextBox);
        userPanelBox.add(Box.createHorizontalStrut(40));
        userPanelBox.add(startResultBox);
        userPanelBox.add(Box.createHorizontalStrut(10));

        infoGathererPanel.add(userPanelBox,BorderLayout.CENTER);
        infoGathererPanel.setBorder(new EtchedBorder()); // делает обводку панели кнопок

        loadButton.addActionListener(new LoadButtonActionListener()); //привязка действий - "листенеров" к кнопкам
        prevButton.addActionListener(new PrevButtonActionListener());
        nextButton.addActionListener(new NextButtonActionListener());
        startButton.addActionListener(new StartButtonActionListener());
        resultButton.addActionListener(new ResultButtonActionListener());
    }

    public JPanel getPanel(){
        return infoGathererPanel;
    }
    public class LoadButtonActionListener implements ActionListener{ //класс-листенер для кнопки load

        @Override
        public void actionPerformed(ActionEvent event){
            String str=("");

            int min = 0, max = 0, size = 0;

            while (true) {
                try {
                    min = Integer.parseInt(txtFieldMinSize.getText());
                    max = Integer.parseInt(txtFieldMaxSize.getText());
                    size = Integer.parseInt(txtFieldSize.getText());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("НЕВЕРНЫЙ ВВОД"); //TODO не работает обработка неверного ввода
                }
            }

            array = new Array(min,max,size);
            arrayList = new ArrayList<Step>();
            quickSort(array, arrayList, 0, array.getArray().length); //TODO засимович делает квик сорт
            arrayList.get(nextPrevIndex).paint();


            txtFieldMinSize.setText(str); // сбрасывает текст из текстфилдов
            txtFieldMaxSize.setText(str);
            txtFieldSize.setText(str);
            prevButton.setEnabled(false); // выключает кнопку prev, тк будет 0й шаг алгоритма и назад некуда
            nextButton.setEnabled(true); //активирует кнопки для запуска алгоритма
            startButton.setEnabled(true);
            resultButton.setEnabled(true);
        }
    }

    public class PrevButtonActionListener implements ActionListener{ //класс-листенер для кнопки prev

        @Override
        public void actionPerformed(ActionEvent event){
            nextButton.setEnabled(true);// включает кнопку некст тк был шаг назад значит можем и вперед
            if (nextPrevIndex>=1) {
                arrayList.get(--nextPrevIndex).paint();
            } else {
                System.out.println("НЕЛЬЗЯ ОТРИСОВАТЬ ОТРИЦАТЕЛЬНЫЙ ШАГ"); //TODO сделать вывод ошибки или блокировку кнопок
            }
        }
    }

    public class NextButtonActionListener implements ActionListener{//класс-листенер для кнопки next

        @Override
        public void actionPerformed(ActionEvent event){
            prevButton.setEnabled(true); // включает кнопку прев тк был шаг вперед значит можем и назад
            if (nextPrevIndex<=arrayList.size()) {
                arrayList.get(++nextPrevIndex).paint();
            } else {
                System.out.println("ВЫШЛИ ЗА ГРАНИЦЫ СПИСКА"); //TODO сделать вывод ошибки или блокировку кнопок
            }
        }
    }

    public class StartButtonActionListener implements ActionListener{//класс-листенер для кнопки start

        @Override
        public void actionPerformed(ActionEvent event){
            loadButton.setEnabled(false); //выключает все кнопки чтобы пользователь не мог помешать работе отображения
            prevButton.setEnabled(false);
            nextButton.setEnabled(false);
            startButton.setEnabled(false);
            resultButton.setEnabled(false);

            for (nextPrevIndex = 0; nextPrevIndex < arrayList.size(); nextPrevIndex++) {
                arrayList.get(nextPrevIndex).paint();
                try {
                    Thread.sleep(3000); //TODO 3000 миллисекунд - очень много
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            loadButton.setEnabled(true); // возвращает все кнопки кроме некст тк последний шаг и дальше некуда
            prevButton.setEnabled(true);
            startButton.setEnabled(true);
            resultButton.setEnabled(true);
        }
    }

    public class ResultButtonActionListener implements ActionListener{//класс-листенер для кнопки result

        @Override
        public void actionPerformed(ActionEvent event){
            prevButton.setEnabled(true); // активирует кнопку, на всякий случае если она была выключена
            nextButton.setEnabled(false); // выключает нектс тк дальше некуда

            arrayList.get(end).paint(); //TODO доступ к последнему элементу
        }
    }

}