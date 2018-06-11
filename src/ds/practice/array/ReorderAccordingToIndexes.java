package ds.practice.array;

public class ReorderAccordingToIndexes {
    public static void main(String[] args) {
        int arr[] = {50, 40, 70, 60, 90};
        int index[] = {3,  0,  4,  1,  2};
        reorderForIndex(arr,index);
    }

    private static void reorderForIndex(int[] arr, int[] index) {
        for (int i = 0; i < arr.length; i++) {
            while (index[i] != i){
                //Store the correct value in temporary index
                int indexVal = index[i];
                int val = arr[indexVal];
                //
            }
        }
    }
}
