package ds.practice.array;

public class PrintArrayRotations {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        printKRightRotation(arr,3);
        printKRightRotation(arr,1);
        printKRightRotation(arr,5);
    }

    private static void printKLeftRotation(int[] arr, int i) {
        for (int j = i; j < arr.length+i; j++) {
            System.out.println(arr[j%arr.length]);
        }
    }

    private static void printKRightRotation(int[] arr, int i){
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[((arr.length - i)+j)%arr.length]);
        }
        System.out.println();
    }


}
