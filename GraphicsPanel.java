import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel{

    private static final long serialVersionUID = 7465942729698560476L;

    private Arrow arrow;
    private Line line;

    private int[] size; // размер элемента
    private int pivots; // номер остова
    private int change1; // номер 1 меняемого
    private int change2; //номер 2го меняемого
    private int quant = 1; // размер массива
    private int max = 1; // размер максимального э-та
    private int space = 3; // такие пробелы будут. (это const)

    public GraphicsPanel(){
        int[] tmp = {0};
        this.size = tmp; // размер элемента
        this.pivots = -1; // номер остова
        this.change1 = -1; // номер 1 меняемого
        this.change2 = -1; //номер 2го меняемого
        this.quant = 1; // размер массива
        this.max = -1; // размер максимального э-та
    }


    public GraphicsPanel(int[] sizes, int pivot, int[] changingElementsIndexes, int quantity, int maximum) {
        this.size = sizes; // размер элемента
        this.pivots = pivot; // номер остова
        this.change1 = changingElementsIndexes[0]; // номер 1 меняемого
        this.change2 = changingElementsIndexes[1]; //номер 2го меняемого
        this.quant = quantity; // размер массива
        this.max = maximum; // размер максимального э-та
    }


    @Override
    public void paintComponent(Graphics g) { // 962 x 557

        int coordx; // инициализация для формулы
        int weight; // инициализация для формулы
        int height; // инициализация для формулы

        int lineX1 = change1 * (((900 - (quant - 1) * space) / quant) + space) + 80 + ((900 - (quant - 1) * space) / quant) / 2; // формулы координат для соединяющей стрелки линии
        int lineX2 = change2 * (((900 - (quant - 1) * space) / quant) + space) + 80 + ((900 - (quant - 1) * space) / quant) / 2;

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK); // цвет рисовальщика
        g2.fillRect(50, 50, 962, 557);

        g2.setColor(Color.WHITE); // цвет рисовальщика

        for(int i = 0; i < quant; ++i) {

            coordx = i * (((900 - (quant - 1) * space) / quant) + space) + 80; // формула координаты х
            weight = (900 - (quant - 1) * space) / quant; // формула ширины
            height = size[i] * (400 / max); // формула высоты

            g2.setColor(Color.WHITE); // цвет элементов


            if ((i == change1)||(i == change2)) {
                g2.setColor(Color.CYAN);
                arrow = new Arrow(coordx+weight / 2, 145, coordx+weight / 2, 70);
                g2.draw(arrow.axis);
                g2.draw(arrow.leftWing);
                g2.draw(arrow.rightWing);
            }

            if (i == pivots) {
                g2.setColor(Color.RED); // цвет остовного элемента
            }

            g2.fillRect(coordx, 150, weight, height);
        }
        g2.setColor(Color.CYAN);
        line = new Line(lineX1,70,lineX2,70); // соединяющая стрелки линия
        if (change1 != -1) g2.draw(line);
    }

}
