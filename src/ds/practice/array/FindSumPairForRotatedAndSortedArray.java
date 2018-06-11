package ds.practice.array;

public class FindSumPairForRotatedAndSortedArray {
    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        findSumPair(arr,16);
    }

    private static void findSumPair(int[] arr, int i) {
        //Step 1. Find Pivot
        int j;
        for (j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                break;
            }
        }
        int max = j;
        int min = (j + 1) % arr.length;
        while (max < min) {
            int sum = arr[min] + arr[max];
            if (sum == i) {
                break;
            }
            if (sum < i) {
                min = (min + 1) % arr.length;
            } else {
                max = (arr.length + max - 1) % arr.length;
            }
        }
        System.out.println("Pairs are " + arr[min] + " and " + arr[max]);
    }
}
