/**
 * Created by Maxim on 26/06/2017.
 */
public class Array {
    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private int leftBorder;
    private int size;
    private int[] array;
    private int rightBorder;

    Array() {}

    Array(int leftBorder, int rightBorder, int size) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.size = size;
        this.array = generation(this.size);
    }

    private int[] generation(int size) {
        int[] res = new int[size];
        System.out.println("Сгенерированный массив с границами " + leftBorder + " и " + rightBorder + " размера " + size);
        for (int i = 0; i < size; i++) {
            res[i] = leftBorder + (int) (Math.random()*(rightBorder-leftBorder));
            System.out.println(res[i] + " ");
        }

        return res;
    }
}
