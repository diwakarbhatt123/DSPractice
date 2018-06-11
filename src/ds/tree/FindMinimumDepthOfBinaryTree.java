package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 *           1
 *         /   \
 *        2    3
 *       /\   /\
 *      4  5 6 7
 *     /
 *    8
 *
 */

public class FindMinimumDepthOfBinaryTree<T> {
    Node<T> root;

    public static void main(String[] args) {
        FindMinimumDepthOfBinaryTree tree_level = new FindMinimumDepthOfBinaryTree();
        tree_level.root = new Node<>(1);
        tree_level.root.left = new Node<>(2);
        tree_level.root.right = new Node<>(3);
        tree_level.root.left.left = new Node<>(4);
        tree_level.root.left.left.left = new Node<>(8);
        tree_level.root.left.right = new Node<>(5);
        tree_level.root.right.left = new Node<>(6);
        tree_level.root.right.right = new Node<>(7);
        tree_level.findMinDepth2(tree_level.root);
    }


    public int findMinDepth() {
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        int depth = 0;
        while (!nodes.isEmpty()) {
            Node<T> polledNode = nodes.poll();
            if (polledNode.left == null && polledNode.right == null) {
                break;
            } else {
                depth++;
                if (polledNode.left != null) {
                    nodes.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    nodes.add(polledNode.right);
                }
            }
        }
        return depth;
    }

    public int findMinDepth2(Node<T> root){
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return findMinDepth2(root.right)+1;
        }
        if(root.right == null){
            return findMinDepth2(root.left)+1;
        }
        return Math.min(findMinDepth2(root.left),findMinDepth2(root.right))+1;
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
