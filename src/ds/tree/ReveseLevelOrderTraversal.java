package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReveseLevelOrderTraversal<T> {

    private Node<T> root;

    public static void main(String[] args) {
        ReveseLevelOrderTraversal tree_level = new ReveseLevelOrderTraversal();
        tree_level.root = new Node<>(1);
        tree_level.root.left = new Node<>(2);
        tree_level.root.right = new Node<>(3);
        tree_level.root.left.left = new Node<>(4);
        tree_level.root.left.right = new Node<>(5);
        tree_level.reverseLevelTraversal();
    }


    private void reverseLevelTraversal() {
        Queue<Node<T>> nodes = new LinkedList<>();
        fillStackWithNode(root, nodes);
        while (!(nodes.isEmpty())){
            System.out.println(nodes.poll().data);
        }
    }

    private void fillStackWithNode(Node<T> root , Queue<Node<T>> nodes){
        if(root == null){
            return;
        }else {
            fillStackWithNode(root.left,nodes);
            fillStackWithNode(root.right, nodes);
            nodes.add(root);
        }
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
