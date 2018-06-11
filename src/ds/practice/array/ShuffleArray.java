package ds.practice.array;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        shuffleArray(arr);
        Random random = ThreadLocalRandom.current();
    }

    private static void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
