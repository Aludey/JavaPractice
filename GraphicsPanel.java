import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7465942729698560476L;

	
	@Override
	public void paintComponent(Graphics g){
		int number = 5; // порядковый номер элемента
		int n = 100; // размер элемента
		int scale = 4; // коэф. скаллирования
		int k = 10; // количество элементов
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE); // цвет рисовальщика
		for(int i=0;i<k;++i){
			g2.setColor(Color.WHITE); // цвет элементов
			if (i==number)g2.setColor(Color.RED); // цвет остовного элемента
			if(i==7)g2.setColor(Color.CYAN);
			g2.fillRect(215*(i+1)/k+((700/k)*i), 120, 700/k-5, n*scale);	
		}		
	}
}
