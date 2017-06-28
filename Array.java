public class Array {

    private int leftBorder;
    private int size;
    private int[] array;
    private int rightBorder;


    public int getLeftBorder() {
        return leftBorder;
    }
    public int getRightBorder() {
        return rightBorder;
    }
    public int getSize() {
        return size;
    }
    public int[] getArray() {
        return array;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }
    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setArray(int[] array) {
        this.array = array;
    }

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
            res[i] = leftBorder + (int) (Math.random()*(rightBorder-leftBorder+1));
            System.out.print(res[i] + " ");
        }
        System.out.println();

        return res;
    }

}
