package ds.arrays;

public class FindNumberOfRotation {

    public static void main(String[] args) {
        int arr[] = new int[]{7, 9, 11, 12, 15};
        System.out.println(findNumberOfRotations(arr, 0, arr.length - 1));
    }

    public static int findNumberOfRotations(int arr[], int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid - 1] > arr[mid]) {
            return mid;
        } else if (arr[mid] < arr[arr.length - 1]) {
            return findNumberOfRotations(arr, low, mid - 1);
        } else {
            return findNumberOfRotations(arr, mid + 1, high);
        }
    }

}
