package ds.practice.array;

/**
 * Q. Find the largest sum of contiguous subarray.
 * We use kadane algorithm to solve this problem.
 * At any point i we any of the maximum sum subarray is either current array element or previous
 * maximum subarray. We find that at every point and update maximum global based on that.
 */
public class MaximumSumContiguosSubarray {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(findMaximumSumContiguousSubArray(arr));
    }

    private static int findMaximumSumContiguousSubArray(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxCurrent + arr[i]) {
                maxCurrent = arr[i];
                start = i;
                end = i;
            } else {
                maxCurrent = maxCurrent + arr[i];
            }
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
                end = i;
            }
        }
        return maxGlobal;
    }
}
