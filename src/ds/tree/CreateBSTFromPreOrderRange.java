package ds.tree;

public class CreateBSTFromPreOrderRange {

    private static Integer index = 0;

    public static void main(String[] args) {
        int arr[] = {10, 5, 1, 7, 40, 50};
        createBinaryTree(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Node<Integer> createBinaryTree(int arr[], Integer min, Integer max) {
        if (index == arr.length) {
            return null;
        }
        if (arr[index] > min && arr[index] < max) {
            Node<Integer> root = new Node<>();
            root.data = arr[index];
            index = index + 1;
            if (index < arr.length) {
                root.left = createBinaryTree(arr, min, root.data);
                root.right = createBinaryTree(arr, root.data, max);
            }
            return root;
        }
        return null;
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
    }
}
