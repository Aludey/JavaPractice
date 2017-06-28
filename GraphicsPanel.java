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
		int number = 5; // ���������� ����� ��������
		int n = 100; // ������ ��������
		int scale = 4; // ����. �������������
		int k = 10; // ���������� ���������
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE); // ���� ������������
		for(int i=0;i<k;++i){
			g2.setColor(Color.WHITE); // ���� ���������
			if (i==number)g2.setColor(Color.RED); // ���� ��������� ��������
			if(i==7)g2.setColor(Color.CYAN);
			g2.fillRect(215*(i+1)/k+((700/k)*i), 120, 700/k-5, n*scale);	
		}		
	}
}
