package ds.tree;

import java.util.Arrays;

public class CreateBSTFromPreorder {

    public static void main(String[] args) {
        int arr[] = {10, 5, 1, 7, 40, 50};
        createBinarySearchTree(arr);
    }

    public static Node<Integer> createBinarySearchTree(int arr[]) {
        if(arr.length == 0){
            return null;
        }
        Node<Integer> root = new Node<>();
        root.data = arr[0];
        if(arr.length > 1){

            int i;
            for (i = 1; i < arr.length; i++) {
                if (arr[i] > arr[0]) {
                    break;
                }
            }
            root.left = createBinarySearchTree(Arrays.copyOfRange(arr, 1, i));
            root.right = createBinarySearchTree(Arrays.copyOfRange(arr, i, arr.length));
        }
        return root;
    }

    static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
    }

}
