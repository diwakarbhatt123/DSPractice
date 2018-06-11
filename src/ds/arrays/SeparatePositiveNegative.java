package ds.arrays;


//Given an array of positive and negative numbers,
// arrange them such that all negative integers appear before all the positive integers in the array without using any additional data structure like hash table, arrays, etc.
// The order of appearance should be maintained.
public class SeparatePositiveNegative {
    public static void main(String[] args) {
        int a[] = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        separatePositiveNegative(0, a.length - 1, a);
    }

    private static void separatePositiveNegative(int left, int right, int[] array) {
        if (left < right) {
            int middle = (left + right) / 2;
            separatePositiveNegative(left, middle, array);
            separatePositiveNegative(middle + 1, right, array);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        //Does Something
        System.out.println("left "+left+" middle "+middle+" right "+right);
    }
}
