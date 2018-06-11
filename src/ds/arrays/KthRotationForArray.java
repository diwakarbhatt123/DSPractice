package ds.arrays;

public class KthRotationForArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 7, 9};
        findKthRotation(arr,2);
    }

    public static void findKthRotation(int arr[], int k){
        //Starting position after kth rotation
        int start = k % arr.length;

        for (int i = start; i < start+arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
