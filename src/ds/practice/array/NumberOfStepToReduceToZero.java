package ds.practice.array;

import java.util.Arrays;

public class NumberOfStepToReduceToZero {
    public static void main(String[] args) {
        int target[] = {16, 16, 16};
        reduceToZero(target);
    }

    private static void reduceToZero(int[] target) {
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] % 2 != 0) {
                count++;
                target[i] -= 1;
            }
            while (target[i] != 0) {
                count++;
                target[i] /= 2;
            }
        }
        System.out.println(count);
//        Arrays.sort();


    }
}
