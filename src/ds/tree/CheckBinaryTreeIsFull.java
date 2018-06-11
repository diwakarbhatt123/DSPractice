package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree is full if a particular node has 2 or less child.
 */
public class CheckBinaryTreeIsFull {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.left = new Node<>(2);
        node.right = new Node<>(3);
        node.left.left = new Node<>(4);
        node.left.right = new Node<>(5);
        System.out.println(isFullBinaryTree(node));
    }

    public static boolean isFullBinaryTree(Node<Integer> root){
        if(root == null){
            return false;
        }
        Queue<Node<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node<Integer> node = nodeQueue.poll();
            if(((node.left == null) ^ (node.right == null))){
                return false;
            }else {
                if (node.left != null){
                    nodeQueue.add(node.left);
                }
                if (node.right != null){
                    nodeQueue.add(node.right);
                }
            }
        }
        return true;
    }

    static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
