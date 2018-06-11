package ds.practice.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(4);
        root.left = new Node<>(2);
        root.right = new Node<>(1);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(10);
        root.right.left = new Node<>(12);
        root.right.right = new Node<>(24);
        printNodesByLevelLineByLine(root);
        printNodesInReverseLevel(root);

    }

    public static void printNodesByLevel(Node<Integer> root){
        Queue<Node<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node<Integer> poppedNode = nodes.poll();
            System.out.println(poppedNode.data);
            if(poppedNode.left != null){
                nodes.add(poppedNode.left);
            }
            if(poppedNode.right != null){
                nodes.add(poppedNode.right);
            }
        }
    }


    public static void printNodesByLevelLineByLine(Node<Integer> root){
        Queue<Node<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while (true){
            int nodesInLevel = nodes.size();
            if(nodesInLevel == 0){
                break;
            }
            while (nodesInLevel > 0){
                Node<Integer> integerNode = nodes.poll();
                System.out.print(integerNode.data + " ");
                if(integerNode.left!= null){
                    nodes.add(integerNode.left);
                }
                if(integerNode.right != null){
                    nodes.add(integerNode.right);
                }
                nodesInLevel--;
            }
            System.out.println();
        }
    }

    public static void printNodesInReverseLevel(Node<Integer> root){
        Queue<Node<Integer>> nodes = new LinkedList<>();
        Stack<Node<Integer>> nodeStack = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node<Integer> polledNode = nodes.poll();
            nodeStack.push(polledNode);
            if(polledNode.left != null){
                nodes.add(polledNode.left);
            }
            if(polledNode.right != null){
                nodes.add(polledNode.right);
            }
        }
        while (!nodeStack.isEmpty()){
            System.out.println(nodeStack.pop().data);
        }
    }

    public static void printNodeInReverseLevelLineByLine(Node<Integer> root){
        Queue<Node<Integer>> nodes = new LinkedList<>();
        Stack<Node<Integer >> nodeStack = new Stack<>();
        nodes.add(root);
        while (true){
            int nodesInCurrLevel = nodes.size();
            if(nodesInCurrLevel == 0){
                break;
            }
            while (nodesInCurrLevel > 0){
                Node<Integer> polledNode = nodes.poll();
                nodeStack.push(polledNode);
                if(polledNode.left!=null){
                    nodes.add(polledNode.left);
                }
                if(polledNode.right != null){
                    nodes.add(polledNode.right);
                }
                nodesInCurrLevel--;
            }
        }
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
