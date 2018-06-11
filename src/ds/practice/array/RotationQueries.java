package ds.practice.array;

public class RotationQueries {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int queries[][] = {
                {1, 2},
                {3, 0, 2},
                {2, 1},
                {3, 1, 4}
        };
        countArray(arr,queries);
    }

    private static void countArray(int[] arr, int[][] queries) {
        //Step 1. Count prefix array
        int prefixArr [] = new int[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i-1] + arr[i-1];
        }

        int startIndex = 0;

        //Step 2: Run through queries
        for (int i = 0; i < queries.length; i++) {
            switch (queries[i][0]){
                //Right Rotate
                case 1:
                    int rightRotations = queries[i][1];
                    startIndex = (startIndex - rightRotations) % arr.length;
                    break;
                //Left rotate
                case 2:
                    int leftRotations = queries[i][1];
                    startIndex = (startIndex + leftRotations) % arr.length;
                    break;
                //Sum between range
                case 3:

                    break;
            }
        }
    }
}
