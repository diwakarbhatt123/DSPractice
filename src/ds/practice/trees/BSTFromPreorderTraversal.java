package ds.practice.trees;

public class BSTFromPreorderTraversal {
    private static Integer currIndex = 0;

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        Node<Integer> root = createBSTFromPreOrder(pre);
        System.out.println(root);
    }

    public static Node<Integer> createBSTFromPreOrder(int preorder[]) {
        Integer index = 0;
        return createBST(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static Node<Integer> createBST(int pre[], Integer max, Integer min) {
        if (currIndex >= pre.length) {
            return null;
        }
        Node<Integer> root = null;
        if (pre[currIndex] > min && pre[currIndex] < max) {
            root = new Node<>(pre[currIndex]);
            currIndex++;
            if (currIndex < pre.length) {
                root.left = createBST(pre, root.data, min);
                root.right = createBST(pre, max, root.data);
            }
        }
        return root;
    }
}
