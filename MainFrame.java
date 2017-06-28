import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4700133615545878302L;
	
	private String title; //титульник окна
	private Dimension dmnsn; // размер
	
	private JPanel mainPanel = new JPanel(new GridBagLayout()); // Главная панель на которой размещаются панели для кнопок и изображения
	private JPanel infoGathererPanel = new JPanel(new GridBagLayout()); //панель для кнопок
	private JPanel mainScreenPanel = new JPanel(new GridBagLayout()); //панель для отображения работы
	
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
	
	infoGathererPanel.setBorder(new EtchedBorder()); // делает обводку панели кнопок
	mainScreenPanel.setBackground(Color.BLACK); // делает панель вывода алгоритма черной
	
	prevButton.setEnabled(false); //выключает кнопки, чтобы юзер не мог их активировать до загрузки данных
	nextButton.setEnabled(false);
	startButton.setEnabled(false);
	resultButton.setEnabled(false);
	
	lblMinSize.setFont(new Font("Arial",Font.BOLD,12)); // редактирует шрифты
	lblMaxSize.setFont(new Font("Arial",Font.BOLD,12));
	lblDefis.setFont(new Font("Arial",0,20));
	lblSize.setFont(new Font("Arial",Font.BOLD,12));

	mainPanel.add(mainScreenPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, //добавляет панель вывода, на главную панель в верхнюю часть
			GridBagConstraints.NORTH, GridBagConstraints.BOTH,
			new Insets(30,30,130,30), 0, 0));
	
	mainPanel.add(infoGathererPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, //добавляет панель кнопок на главную панель снизу
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
			new Insets(0,30,15,30), 0, 0));
	
	infoGathererPanel.add(txtFieldMinSize, new GridBagConstraints(0, 1, 1, 1, 1, 1, // множество доваблений кнопок, текстфилдов
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, //и лейблов на панель кнопок
			new Insets(0,10,12,0), 0, 0));
	infoGathererPanel.add(lblDefis, new GridBagConstraints(1, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
			new Insets(0,2,12,0), 0, 0));
	infoGathererPanel.add(txtFieldMaxSize, new GridBagConstraints(2, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
			new Insets(0,0,12,10), 0, 0));
	infoGathererPanel.add(txtFieldSize, new GridBagConstraints(3, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
			new Insets(0,10,12,0), 0, 0));
	infoGathererPanel.add(loadButton, new GridBagConstraints(4, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(0,15,17,30), 0, 0));
	infoGathererPanel.add(prevButton, new GridBagConstraints(5, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(0,30,17,5), 0, 0));
	infoGathererPanel.add(nextButton, new GridBagConstraints(6, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(0,5,17,30), 0, 0));
	infoGathererPanel.add(startButton, new GridBagConstraints(7, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(0,30,17,30), 0, 0));
	infoGathererPanel.add(resultButton, new GridBagConstraints(8, 1, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(0,30,17,10), 0, 0));
	infoGathererPanel.add(lblMinSize, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(12,10,0,0), 0, 0));
	infoGathererPanel.add(lblMaxSize, new GridBagConstraints(2, 0, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(12,0,0,10), 0, 0));
	infoGathererPanel.add(lblSize, new GridBagConstraints(3, 0, 1, 1, 1, 1, 
			GridBagConstraints.SOUTH, GridBagConstraints.NONE,
			new Insets(12,10,0,0), 0, 0));
	
	
	loadButton.addActionListener(new LoadButtonActionListener()); //привязка действий - "листенеров" к кнопкам
	prevButton.addActionListener(new PrevButtonActionListener());
	nextButton.addActionListener(new NextButtonActionListener());
	startButton.addActionListener(new StartButtonActionListener());
	resultButton.addActionListener(new ResultButtonActionListener());
	
	GraphicsPanel gp = new GraphicsPanel(); // создание графической панели для графики
	mainScreenPanel.add(gp,new GridBagConstraints(1, 0, 1, 1, 1, 1, // добавление графической панели на панель вывода
		GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
		new Insets(2,2,2,2), 0, 0));
	
	setVisible(true);
	}
	
	public class LoadButtonActionListener implements ActionListener{ //класс-листенер для кнопки load

		@Override
		public void actionPerformed(ActionEvent event){
			String str=("");			
			/*
			 * Код загрузки данных
			 */
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
			/*
			 * Код перехода на шаг назад Enable(false) в начале
			 */
		}
	}
	
	public class NextButtonActionListener implements ActionListener{//класс-листенер для кнопки next

		@Override
		public void actionPerformed(ActionEvent event){
			prevButton.setEnabled(true); // включает кнопку прев тк был шаг вперед значит можем и назад
			/*
			 * Код перехода на шаг вперед Enable(false) в конце
			 */
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
			/*
			 * Код пошагового отображения алгоритма
			 */
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
			/*
			 * Код для отображения результата
			 */
		}
	}
}