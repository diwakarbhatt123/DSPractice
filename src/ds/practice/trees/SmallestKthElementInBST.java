package ds.practice.trees;

import java.util.Stack;

public class SmallestKthElementInBST {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(20);
        root.left = new Node<>(8);
        root.right = new Node<>(22);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(12);
        root.left.right.left = new Node<>(10);
        root.left.right.right = new Node<>(14);
        kthLargest(root, 3);
    }

    public static Integer kthSmallest(Node<Integer> root, int k){
        Stack<Node<Integer>> nodeStack = new Stack<>();
        nodeStack.push(root);
        Node<Integer> current = root;
        while (!nodeStack.isEmpty() || current != null) {
            while (current != null) {
                if(current.right !=null) {
                    nodeStack.push(current.left);
                }
                current = current.left;
            }
            if(!nodeStack.isEmpty()){
                Node<Integer> poppedNode = nodeStack.pop();
                if(--k == 0){
                    return poppedNode.data;
                }
                current = poppedNode.right;
            }
        }
        return null;
    }

    public static Integer kthLargest(Node<Integer> root, int k){
        Stack<Node<Integer>> nodeStack = new Stack<>();
        nodeStack.push(root);
        Node<Integer> curr = root;
        while (!nodeStack.isEmpty() || curr != null){
            while (curr != null){
                if(curr.right != null){
                    nodeStack.push(curr.right);
                }
                curr = curr.right;
            }
            if(!nodeStack.isEmpty()){
                Node<Integer> poppedNode = nodeStack.pop();
                if(--k == 0){
                    return poppedNode.data;
                }
                curr = poppedNode.left;
            }
        }
        return null;
    }

}
