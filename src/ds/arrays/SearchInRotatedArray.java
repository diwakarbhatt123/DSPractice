package ds.arrays;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(searchArray(arr, 30));
    }

    public static int searchArray(int[] arr, int searchKey) {
        int pivot = findPivot(arr);
        if (arr[pivot] == searchKey) {
            return pivot;
        }
        int index;
        if (arr[0] < searchKey) {
            index = binarySearch(arr, 0, pivot, searchKey);
        } else {
            index = binarySearch(arr, pivot + 1, arr.length - 1, searchKey);
        }
        return index;
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (end < start){
            return -1;
        }
        if (arr[mid] == key) {
            return mid;
        } else if (key < arr[mid]) {
            return binarySearch(arr, start, mid, key);
        } else {
            return binarySearch(arr, mid + 1, end, key);
        }
    }

    public static int findPivot(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }


}
