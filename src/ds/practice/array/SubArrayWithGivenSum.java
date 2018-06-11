package ds.practice.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int arr1[] = {10, 2, -2, -20, 10};
        int arr2[] = {-10, 0, 2, -2, -20, 10};
        findSumWithSubArrayNegetive(arr2,20);
    }

    private static void findSubArrayWithSum(int[] arr, int i) {
        int start = 0;
        int sum = 0;
        int end = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(sum > i){
                while (start < i && sum != i){
                    sum -= arr[start];
                    start++;
                }
            }
            if(sum == i){
                end = j;
                break;
            }
        }
        System.out.println("Start " + start + " End " + end);
    }

    public static void findSumWithSubArrayNegetive(int arr[], int sum){
        int currSum = 0;
        int start = 0;
        int end = 0;
        Map<Integer,Integer> sumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum == sum){
                end = i;
                break;
            }
            if(sumMap.containsKey(currSum - sum)){
                start = sumMap.get(currSum-sum) +1;
                end = i;
                break;
            }
            sumMap.put(currSum,i);
        }
    }
}
