
import javax.swing.JFrame;


public class SortFrame {
	public static void main(String[] args){
		JFrame sortframe = new JFrame("hophey"); //�������� ����
		sortframe.setSize(300,200); // ������ ����
		sortframe.setVisible(true); // ����������� ����
		sortframe.setResizable(false);//������ ������ ������ ����
		sortframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�������� ���� �� ������
		sortframe.setLocationRelativeTo(null); //�� ��

	}
}