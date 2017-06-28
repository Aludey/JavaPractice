
import javax.swing.JFrame;


public class SortFrame {
	public static void main(String[] args){
		JFrame sortframe = new JFrame("hophey"); //создание окна
		sortframe.setSize(300,200); // размер окна
		sortframe.setVisible(true); // отображение окна
		sortframe.setResizable(false);//нельзя менять размер окна
		sortframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие окна по кресту
		sortframe.setLocationRelativeTo(null); //хз че

	}
}