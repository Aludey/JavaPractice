public class Step {

    private int quantity;
    private int maximum;
    private int pivotsIndex;
    private int[] changingElementsIndexes;
    private int[] elementsValues;

    public int getPivotsIndex() {
        return pivotsIndex;
    }
    public int[] getChangingElementsIndexes() {
        return changingElementsIndexes;
    }
    public int[] getElementsValues() {
        return elementsValues;
    }


    public void setPivotsIndex(int pivotsIndex) {
        this.pivotsIndex = pivotsIndex;
    }
    public void setChangingElementsIndexes(int[] changingElementsIndexes) {
        this.changingElementsIndexes = changingElementsIndexes;
    }
    public void setElementsValues(int[] elementsValues) {
        this.elementsValues = elementsValues;
    }



    public GraphicsPanel paint() {
        GraphicsPanel gp = new GraphicsPanel(elementsValues, pivotsIndex, changingElementsIndexes, quantity, maximum);
        return gp;
    }

    public Step(int pivots, int[] changing, int[] mass) {
        this.pivotsIndex = pivots;
        this.changingElementsIndexes = changing;
        this.elementsValues = mass;
        this.quantity = mass.length;
        this.maximum = 0;
        for (int i = 0; i < mass.length; i++) {
            if (maximum < mass[i]) {
                maximum = mass[i];
            }
        }
    }

}
