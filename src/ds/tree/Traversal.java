package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Example tree
 * <p>
 * 1
 * /  \
 * 2   3
 * / \ / \
 * 4  5
 */

public class Traversal<T> {

    private Node<T> root;

    public static void main(String[] args) {

        Traversal tree_level = new Traversal();
        tree_level.root = new Node<>(1);
        tree_level.root.left = new Node<>(2);
        tree_level.root.right = new Node<>(3);
        tree_level.root.left.left = new Node<>(4);
        tree_level.root.left.right = new Node<>(5);

//        tree_level.printBFSTraversal();
//        tree_level.printInOrder();
//        tree_level.printPreOrder();
//        tree_level.printPostOrder();
          tree_level.getLinkedListFromTree();

    }


    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    public LinkedList<T> getLinkedListFromTree(){
         return getLinkedList(root,new LinkedList<>());
    }

    private LinkedList<T> getLinkedList(Node<T> node, LinkedList<T> linkedList){
        if(node == null){
            return linkedList;
        }
        getLinkedList(node.left, linkedList);
        linkedList.add(node.data);
        getLinkedList(node.right, linkedList);
        return linkedList;
    }

    private void printPreOrder() {
        preOrderIterative(root);
//        preOrder(root);
        System.out.println();
    }

    public void printPostOrder() {
        postOrderIterative2(root);
//        postOrder(root);
        System.out.println();
    }

    private void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "->");
        preOrder(node.left);
        preOrder(node.right);
    }


    private void preOrderIterative(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> poppedNode = stack.pop();
            System.out.println(poppedNode.data);
            if (poppedNode.right != null) {
                stack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                stack.push(poppedNode.left);
            }
        }
    }


    private void postOrderIterative(Node<T> root) {
        Stack<Node<T>> stack1 = new Stack<>();
        Stack<Node<T>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node<T> poppedElement = stack1.pop();
            stack2.push(poppedElement);
            if (poppedElement.left != null) {
                stack1.push(poppedElement.left);
            }
            if (poppedElement.right != null) {
                stack1.push(poppedElement.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data);
        }
    }

    private void postOrderIterative2(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        while (root != null) {
            if (root.right != null) {
                stack.push(root.right);
            }
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right == stack.peek()) {
                stack.pop();
                root = root.right;
            } else {
                System.out.println(root.data);
                root = null;
            }
        }
    }

    private void iterativeInOrder(Node<T> root) {

    }

    private void postOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "->");
    }

    private void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "->");
        inOrder(node.right);
    }


    public void printBFSTraversal() {
        Queue<Node<T>> visitedNodeQueue = new LinkedList<>();
        Node<T> tempNode = root;
        System.out.println(tempNode.data);
        while (tempNode != null) {
            if (tempNode.left != null) {
                System.out.print(tempNode.left.data);
                visitedNodeQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                System.out.print(" " + tempNode.right.data);
                visitedNodeQueue.add(tempNode.right);
            }
            tempNode = visitedNodeQueue.poll();
            System.out.println();
        }
        System.out.println();
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
