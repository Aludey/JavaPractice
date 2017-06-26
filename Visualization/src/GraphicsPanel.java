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
    public void paintComponent(Graphics g) { // 952 x 547
      
    	int size = 0;
    	int ostov = 7;
    	int change1 = 3;
    	int change2 = 49;
    	int quant = 100;
    	int max = quant;
    	int space = 5;
    	
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE); // цвет рисовальщика
        
        for(int i = 0; i < quant; ++i) {
        	size = i+1;
            g2.setColor(Color.WHITE); // цвет элементов
            
            if (i == ostov) {
                g2.setColor(Color.RED); // цвет остовного элемента
            }
            
            if ((i == change1)||(i == change2)) {
                g2.setColor(Color.CYAN);
            }
            
            g2.fillRect(9+i*((957+space)/quant), 97, (957+space)/quant-space, size*(450/max));
        }
    }
}
