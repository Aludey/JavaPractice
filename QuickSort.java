import java.util.ArrayList;


public class QuickSort {
    private int redColumn = -1;

    public void quickSort(int[] arr, ArrayList<Step> list, int low, int high){
        int i = low;
        int j = high;

        int pivot = arr[low + (high - low) / 2];
        redColumn = low + (high - low) / 2;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                if (arr[i] != arr[j]) {
                    System.out.print("(" + arr[i] + " " + arr[j] + ") " + pivot);
                    int[] changing = new int[2];
                    changing[0]=i;
                    changing[1]=j;

                    int[] copy = new int[arr.length];
                    for (int k = 0; k < arr.length; k++)
                    {
                        copy[k]=arr[k];
                    }

                    Step chang = new Step(redColumn,changing,copy);
                    list.add(chang);
                    System.out.println();
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }


                if (i == redColumn) {
                    redColumn = j;
                } else if (j == redColumn) {
                    redColumn = i;
                }

                i++;
                j--;

            }
        }

        if (low < j) {
            quickSort(arr,list,low, j);
        }
        if (i < high) {
            quickSort(arr,list,i, high);
        }
    }


    public void goodQuickSort(int[] arr, ArrayList<Step> list, int low, int high) {
        quickSort(arr, list, low, high);
        int[] changing = new int[2];
        changing[0]=-1;
        changing[1]=-1;
        list.add(new Step(-1, changing, arr));
    }

}
