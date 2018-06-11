package ds.tree;

public class MaxHeight<T> {

    Node<T> root;

    public static void main(String[] args) {
        MaxHeight tree_level = new MaxHeight();
        tree_level.root = new Node<>(1);
        tree_level.root.left = new Node<>(2);
        tree_level.root.right = new Node<>(3);
        tree_level.root.left.left = new Node<>(4);
        tree_level.root.left.left.left = new Node<>(8);
        tree_level.root.left.right = new Node<>(5);
        tree_level.root.right.left = new Node<>(6);
        tree_level.root.right.right = new Node<>(7);
        tree_level.findMaxHeight(tree_level.root);
    }

    public int findMaxHeight(Node<T> root){
        if (root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return findMaxHeight(root.right)+1;
        }
        if (root.right == null){
            return findMaxHeight(root.left)+1;
        }
        return Math.max(findMaxHeight(root.left)+1,findMaxHeight(root.right)+1);
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

}
