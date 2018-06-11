package ds.practice.makemytrip;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrayOfZero {
    public static void main(String[] args) {
        int arr[] = {-1, -2, 3, 15, -8, 1, 7, 10, 13};
        System.out.println(largestSubarrayOfZero(arr));
    }

    public static int largestSubarrayOfZero(int arr[]){
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum==0){
                max_len = i+1;
            }
            Integer prev_len = sumMap.get(sum);
            if(prev_len != null){
                max_len = Math.max(max_len,i-prev_len);
            }else {
                sumMap.put(sum,i);
            }
        }
        return max_len;
    }

}
