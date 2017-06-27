import java.awt.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = -4700133615545878302L;

    private String title; //титульник окна
    private Dimension dmnsn; // размер

    private JPanel mainPanel = new JPanel(new GridBagLayout()); // Главная панель на которой размещаются панели для кнопок и изображения
    private JPanel mainScreenPanel = new JPanel(new GridBagLayout()); //панель для отображения работы

    GraphicsPanel gp = new GraphicsPanel();

    public MainFrame(String title, Dimension dmnsn){ //конструктор базового окна
        this.title = title;
        this.dmnsn = dmnsn;
    }

    public void init(){ // заполнение базового окна
        setTitle(title); // установка титула
        setSize(dmnsn); // задача размеров
        setLayout(new GridBagLayout()); //установка лейоута для размещения компонентов
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при нажатии креста закрывает окно
        setLocationRelativeTo(null); // не понял
        setResizable(false); // нельзя разворачивать на фуллскрин и вообще менять размеры

        mainPanel.setPreferredSize(new Dimension(1000,700)); // ставит предпочитаемый размер основной панели
        mainPanel.setBorder(new EtchedBorder()); // делает обводку главной панели
        add(mainPanel); // добавляет панель на базовое окно

        UserPanel infoGathererPanel = new UserPanel();
        mainScreenPanel.setBackground(Color.BLACK); // делает панель вывода алгоритма черной

        mainScreenPanel.add(gp,new GridBagConstraints(1, 0, 1, 1, 1, 1, // добавление графической панели на панель вывода
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2,2,2,2), 0, 0));

        mainPanel.add(mainScreenPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, //добавляет панель вывода, на главную панель в верхнюю часть
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(15,15,120,15), 0, 0));

        mainPanel.add(infoGathererPanel.getPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, //добавляет панель кнопок на главную панель снизу
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(0,15,15,15), 0, 0));

        setVisible(true);
    }


}