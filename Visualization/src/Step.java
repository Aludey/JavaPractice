/**
 * Created by Maxim on 26/06/2017.
 */
public class Step {
    public void paint() {
        //TODO
    }

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


    private int pivotsIndex;
    private int[] changingElementsIndexes;
    private int[] elementsValues;
}
