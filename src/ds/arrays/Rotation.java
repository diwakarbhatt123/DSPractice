package ds.arrays;

public class Rotation {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        rotateArray(array, 3);
    }

    private static void rotateArray(int[] arr, int rotation){
        for (int i = 0; i < rotation; i++) {
            int first = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j]= arr[j+1];
            }
            arr[arr.length-1] = first;
        }
        System.out.println("Rotated array by "+rotation+" is");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
