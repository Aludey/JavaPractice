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
	
	private String title; //��������� ����
	private Dimension dmnsn; // ������
	
	private JPanel mainPanel = new JPanel(new GridBagLayout()); // ������� ������ �� ������� ����������� ������ ��� ������ � �����������
	private JPanel infoGathererPanel = new JPanel(new GridBagLayout()); //������ ��� ������
	private JPanel mainScreenPanel = new JPanel(new GridBagLayout()); //������ ��� ����������� ������
	
	private JLabel lblMinSize = new JLabel("Left border of the range"); // ��������� ������(�������)
	private JLabel lblMaxSize = new JLabel("Right border of the range");
	private JLabel lblDefis = new JLabel("-");
	private JLabel lblSize = new JLabel("Quantity");
	
	private JButton loadButton = new JButton("Load"); // ������
	private JButton prevButton = new JButton("Prev");
	private JButton startButton = new JButton("Start");
	private JButton nextButton = new JButton("Next");
	private JButton resultButton = new JButton("Result");
	
	private JTextField txtFieldMinSize = new JTextField(8); // ���� ��� ����� ������
	private JTextField txtFieldMaxSize = new JTextField(8);
	private JTextField txtFieldSize = new JTextField(8);	
	
	public MainFrame(String title, Dimension dmnsn){ //����������� �������� ����
		this.title = title;
		this.dmnsn = dmnsn;
	}
	
	public void init(){ // ���������� �������� ����
	setTitle(title); // ��������� ������
	setSize(dmnsn); // ������ ��������
	setLayout(new GridBagLayout()); //��������� ������� ��� ���������� �����������
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ��� ������� ������ ��������� ����
	setLocationRelativeTo(null); // �� �����
	setResizable(false); // ������ ������������� �� ��������� � ������ ������ �������
	
	mainPanel.setPreferredSize(new Dimension(1000,700)); // ������ �������������� ������ �������� ������
	mainPanel.setBorder(new EtchedBorder()); // ������ ������� ������� ������
	add(mainPanel); // ��������� ������ �� ������� ����
	
	infoGathererPanel.setBorder(new EtchedBorder()); // ������ ������� ������ ������
	mainScreenPanel.setBackground(Color.BLACK); // ������ ������ ������ ��������� ������
	
	prevButton.setEnabled(false); //��������� ������, ����� ���� �� ��� �� ������������ �� �������� ������
	nextButton.setEnabled(false);
	startButton.setEnabled(false);
	resultButton.setEnabled(false);
	
	lblMinSize.setFont(new Font("Arial",Font.BOLD,12)); // ����������� ������
	lblMaxSize.setFont(new Font("Arial",Font.BOLD,12));
	lblDefis.setFont(new Font("Arial",0,20));
	lblSize.setFont(new Font("Arial",Font.BOLD,12));

	mainPanel.add(mainScreenPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, //��������� ������ ������, �� ������� ������ � ������� �����
			GridBagConstraints.NORTH, GridBagConstraints.BOTH,
			new Insets(30,30,130,30), 0, 0));
	
	mainPanel.add(infoGathererPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, //��������� ������ ������ �� ������� ������ �����
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
			new Insets(0,30,15,30), 0, 0));
	
	infoGathererPanel.add(txtFieldMinSize, new GridBagConstraints(0, 1, 1, 1, 1, 1, // ��������� ���������� ������, �����������
			GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, //� ������� �� ������ ������
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
	
	
	loadButton.addActionListener(new LoadButtonActionListener()); //�������� �������� - "����������" � �������
	prevButton.addActionListener(new PrevButtonActionListener());
	nextButton.addActionListener(new NextButtonActionListener());
	startButton.addActionListener(new StartButtonActionListener());
	resultButton.addActionListener(new ResultButtonActionListener());
	
	GraphicsPanel gp = new GraphicsPanel(); // �������� ����������� ������ ��� �������
	mainScreenPanel.add(gp,new GridBagConstraints(1, 0, 1, 1, 1, 1, // ���������� ����������� ������ �� ������ ������
		GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
		new Insets(2,2,2,2), 0, 0));
	
	setVisible(true);
	}
	
	public class LoadButtonActionListener implements ActionListener{ //�����-�������� ��� ������ load

		@Override
		public void actionPerformed(ActionEvent event){
			String str=("");			
			/*
			 * ��� �������� ������
			 */
			txtFieldMinSize.setText(str); // ���������� ����� �� �����������
			txtFieldMaxSize.setText(str);
			txtFieldSize.setText(str);
			prevButton.setEnabled(false); // ��������� ������ prev, �� ����� 0� ��� ��������� � ����� ������
			nextButton.setEnabled(true); //���������� ������ ��� ������� ���������
			startButton.setEnabled(true);
			resultButton.setEnabled(true);
		}
	}
	
	public class PrevButtonActionListener implements ActionListener{ //�����-�������� ��� ������ prev

		@Override
		public void actionPerformed(ActionEvent event){
			nextButton.setEnabled(true);// �������� ������ ����� �� ��� ��� ����� ������ ����� � ������
			/*
			 * ��� �������� �� ��� ����� Enable(false) � ������
			 */
		}
	}
	
	public class NextButtonActionListener implements ActionListener{//�����-�������� ��� ������ next

		@Override
		public void actionPerformed(ActionEvent event){
			prevButton.setEnabled(true); // �������� ������ ���� �� ��� ��� ������ ������ ����� � �����
			/*
			 * ��� �������� �� ��� ������ Enable(false) � �����
			 */
		}
	}
	
	public class StartButtonActionListener implements ActionListener{//�����-�������� ��� ������ start

		@Override
		public void actionPerformed(ActionEvent event){
			loadButton.setEnabled(false); //��������� ��� ������ ����� ������������ �� ��� �������� ������ �����������
			prevButton.setEnabled(false);
			nextButton.setEnabled(false);
			startButton.setEnabled(false);
			resultButton.setEnabled(false);
			/*
			 * ��� ���������� ����������� ���������
			 */
			loadButton.setEnabled(true); // ���������� ��� ������ ����� ����� �� ��������� ��� � ������ ������
			prevButton.setEnabled(true);
			startButton.setEnabled(true);
			resultButton.setEnabled(true);
		}
	}
	
	public class ResultButtonActionListener implements ActionListener{//�����-�������� ��� ������ result

		@Override
		public void actionPerformed(ActionEvent event){
			prevButton.setEnabled(true); // ���������� ������, �� ������ ������ ���� ��� ���� ���������
			nextButton.setEnabled(false); // ��������� ����� �� ������ ������
			/*
			 * ��� ��� ����������� ����������
			 */
		}
	}
}