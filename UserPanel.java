import java.awt.BorderLayout;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class UserPanel extends JPanel{
    private static final long serialVersionUID = -8005126132273764537L;

    private JPanel infoGathererPanel = new JPanel(new BorderLayout()); //панель для кнопок

    private JLabel lblMinSize = new JLabel("Left border of the range"); // Различные лейблы(надписи)
    private JLabel lblMaxSize = new JLabel("Right border of the range");
    private JLabel lblDefis = new JLabel("-");
    private JLabel lblSize = new JLabel("Quantity");

    public JButton loadButton = new JButton("Load"); // Кнопки
    public JButton prevButton = new JButton("Prev");
    public JButton startButton = new JButton("Start");
    public JButton nextButton = new JButton("Next");
    public JButton resultButton = new JButton("Result");


    public JTextField txtFieldMinSize = new JTextField(8); // Поля для ввода текста
    public JTextField txtFieldMaxSize = new JTextField(8);
    public JTextField txtFieldSize = new JTextField(8);


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
        startResultBox.add(Box.createHorizontalStrut(23));
        startResultBox.add(resultButton);

        prevNextBox.add(prevButton);
        prevNextBox.add(Box.createHorizontalStrut(10));
        prevNextBox.add(nextButton);

        infoGathererBox.add(txtFieldMinSize);
        infoGathererBox.add(Box.createHorizontalStrut(2));
        infoGathererBox.add(lblDefis);
        infoGathererBox.add(Box.createHorizontalStrut(2));
        infoGathererBox.add(txtFieldMaxSize);
        infoGathererBox.add(Box.createHorizontalStrut(20));
        infoGathererBox.add(txtFieldSize);

        labelBox.add(lblMinSize);
        labelBox.add(Box.createHorizontalStrut(25));
        labelBox.add(lblMaxSize);
        labelBox.add(Box.createHorizontalStrut(70));
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
        userPanelBox.add(Box.createHorizontalStrut(23));
        userPanelBox.add(prevNextBox);
        userPanelBox.add(Box.createHorizontalStrut(23));
        userPanelBox.add(startResultBox);
        userPanelBox.add(Box.createHorizontalStrut(10));

        infoGathererPanel.add(userPanelBox,BorderLayout.CENTER);
        infoGathererPanel.setBorder(new EtchedBorder()); // делает обводку панели кнопок

    }

    public JPanel getPanel(){
        return infoGathererPanel;
    }

}