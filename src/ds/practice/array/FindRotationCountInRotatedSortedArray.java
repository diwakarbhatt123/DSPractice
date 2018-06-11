package ds.practice.array;

public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {7, 9, 11, 12, 5};
        findRotationCount(arr);
    }

    private static void findRotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[mid - 1]) {
                System.out.println(mid);
                break;
            }
            if (arr[mid] > arr[mid + 1]) {
                System.out.println(mid + 1);
                break;
            }
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }

}
