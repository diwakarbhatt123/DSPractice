package ds.tree;

import java.util.Stack;

public class InOrderTraversalWithoutRecursion<T> {

    private Node<T> root;

    public static void main(String[] args) {
        InOrderTraversalWithoutRecursion tree_level = new InOrderTraversalWithoutRecursion();
        tree_level.root = new Node<>(1);
        tree_level.root.left = new Node<>(2);
        tree_level.root.right = new Node<>(3);
        tree_level.root.left.left = new Node<>(4);
        tree_level.root.left.left.left = new Node<>(8);
        tree_level.root.left.right = new Node<>(5);
        tree_level.root.right.left = new Node<>(6);
        tree_level.root.right.right = new Node<>(7);
        tree_level.inOrderWithoutStack();
    }

    public void inOrderTraversalWithoutRecursion() {
        Stack<Node<T>> nodes = new Stack<>();
        Node<T> current = root;
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                nodes.push(current);
                current = current.left;
            }
            Node<T> poppedNode = nodes.pop();
            System.out.println(poppedNode.data);
            if (poppedNode.right != null) {
                current = poppedNode.right;
            }
        }
    }

    public void inOrderWithoutStack(){
        Node<T> currentNode = root;

        while (currentNode != null) {

            if (currentNode.getLeft() == null) {
                System.out.println(currentNode.getData());

                currentNode = currentNode.getRight();
            } else {
                final Node<T> leftNode = currentNode.getLeft();
                final Node<T> rightMostChildInLeftSubTree = getRightMostChild(leftNode);

                currentNode.setLeft(null);
                rightMostChildInLeftSubTree.setRight(currentNode);

                currentNode = leftNode;
            }

        }
    }

    private Node<T> getRightMostChild(Node<T> root) {
        if (root.getRight() == null) {
            return root;
        }
        return getRightMostChild(root.getRight());
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
