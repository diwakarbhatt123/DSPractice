package ds.arrays;

public class RotationWithJuggling {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        rotateArray(arr, 3);
    }

    public static void rotateArray(int[] arr, int rotate) {
        int temp,k,j;
        for (int i = 0; i < gcd(rotate, arr.length); i++)
        {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true)
            {
                k = j + rotate;
                if (k >= arr.length)
                    k = k - arr.length;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

}
