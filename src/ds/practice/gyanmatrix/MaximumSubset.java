package ds.practice.gyanmatrix;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubset {
    public static void main(String[] args) {
        int inputArr[] = {1,2,2,3,3};
        printMaximumSubset(inputArr);
    }

    private static void printMaximumSubset(int[] inputArr) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int maxSubsetStart = 0;
        int maxSubsetEnd = 0;
        int currMaxFrequency = 0;
        for (int i = 0; i < inputArr.length; i++) {
            Integer count = countMap.get(inputArr[i]);
            if(count == null){
                countMap.put(inputArr[i],1);
                count = 1;
            } else {
                countMap.put(inputArr[i],count+1);
                count = count+1;
            }
            if(count > currMaxFrequency){
                currMaxFrequency = count;
                
            }
        }
    }
}
