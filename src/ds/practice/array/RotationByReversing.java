package ds.practice.array;

public class RotationByReversing {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotateByReversal(arr, 3);
    }

    private static void rotateByReversal(int[] arr, int i) {
        reverseArrRange(0, i - 1, arr);
        reverseArrRange(i, arr.length - 1, arr);
        reverseArrRange(0, arr.length - 1, arr);
    }

    private static void reverseArrRange(int start, int end, int[] arr) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
