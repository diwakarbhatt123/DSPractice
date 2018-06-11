package ds.practice.array;

public class ElementIndexArray {
    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        elementIndexArray(arr);
    }

    private static void elementIndexArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i];
            while (val != -1 && val < arr.length-1 && arr[val] != val){
                int indexValue = arr[val];
                arr[i] = indexValue;
                arr[val] = val;
                val = indexValue;
            }
        }
    }
}
