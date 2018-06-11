package ds.arrays;


import java.util.Arrays;


//Wave Array is when arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..

public class WaveArray {

    public static void main(String[] args) {
        int a[] = {10, 5, 6, 3, 2, 20, 100, 80};
        sortWave(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sortWave(int[] a) {
        for (int i = 0; i < a.length; i += 2) {
            if (i > 0 && a[i] < a[i - 1]) {
                swapValuesArray(i, i - 1, a);
            }
            if (i + 1 < a.length && a[i] < a[i + 1]) {
                swapValuesArray(i, i + 1, a);
            }
        }
    }

    private static void swapValuesArray(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
