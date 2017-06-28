import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


public class DialogFrame {
	public static void main(String[] args){
		JFrame frame = new JFrame("Ibalrot quick sort"); //создание окна
		frame.setSize(1000,700); // размер окна
		frame.setVisible(true); // отображение окна
		frame.setResizable(false);//нельз€ мен€ть размер окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие окна по кресту
		frame.setLocationRelativeTo(null); //хз че
		frame.setLayout(new GridBagLayout()); //лейоут
		
		JPanel infogatherer = new JPanel(new GridBagLayout());
		infogatherer.setBorder(new EtchedBorder());
		
		JPanel mainscreen = new JPanel();
		mainscreen.setBackground(Color.BLACK);
		
		JLabel lblminsize = new JLabel("Left border of the range");
		lblminsize.setFont(new Font("Arial",Font.BOLD,12));
		JLabel lblmaxsize = new JLabel("Right border of the range");
		lblmaxsize.setFont(new Font("Arial",Font.BOLD,12));
		JLabel defis = new JLabel("-");
		defis.setFont(new Font("Arial",0,20));
		JLabel lblsize = new JLabel("Quantity");
		lblsize.setFont(new Font("Arial",Font.BOLD,12));


		JButton accept = new JButton("Accept");
		JButton prev = new JButton("Prev");
		JButton start = new JButton("Start");
		JButton next = new JButton("Next");
		JButton result = new JButton("Result");
		
		JTextField txtfieldminsize = new JTextField(8);
		JTextField txtfieldmaxsize = new JTextField(8);
		JTextField txtfieldsize = new JTextField(8);
		
		
		frame.add(mainscreen, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(30,30,130,30), 0, 0));
		
		frame.add(infogatherer, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,30,30,30), 0, 0));
		
		infogatherer.add(txtfieldminsize, new GridBagConstraints(0, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,10,12,0), 0, 0));
		infogatherer.add(defis, new GridBagConstraints(1, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,2,12,2), 0, 0));
		infogatherer.add(txtfieldmaxsize, new GridBagConstraints(2, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,0,12,10), 0, 0));
		infogatherer.add(txtfieldsize, new GridBagConstraints(3, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,10,12,0), 0, 0));
		infogatherer.add(accept, new GridBagConstraints(4, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,15,17,30), 0, 0));
		infogatherer.add(prev, new GridBagConstraints(5, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,30,17,5), 0, 0));
		infogatherer.add(next, new GridBagConstraints(6, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,5,17,30), 0, 0));
		infogatherer.add(start, new GridBagConstraints(7, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,30,17,30), 0, 0));
		infogatherer.add(result, new GridBagConstraints(8, 1, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0,30,17,10), 0, 0));
		infogatherer.add(lblminsize, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(12,10,0,0), 0, 0));
		infogatherer.add(lblmaxsize, new GridBagConstraints(2, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(12,0,0,10), 0, 0));
		infogatherer.add(lblsize, new GridBagConstraints(3, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(12,10,0,0), 0, 0));
		
		frame.setState(JFrame.ICONIFIED); // костыль, спросить! ” мен€ без сворачивани€
		frame.setExtendedState(JFrame.NORMAL);// разворачивани€ не отображаютс€
	}
}