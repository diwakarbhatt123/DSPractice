package ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *     20
 *     /\
 *    8  22
 *   /\    \
 *  5 3    25
 *   / \
 *  10 14
 */
public class BottomViewOfTree {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(20);
        node.left = new Node<>(8);
        node.right = new Node<>(22);
        node.left.left = new Node<>(5);
        node.left.right = new Node<>(3);
        node.left.right.left = new Node<>(10);
        node.left.right.right = new Node<>(14);
        node.right.right = new Node<>(25);
        printBottomView(node);
    }

    private static void bottomView(Node<Integer> root, Integer level, Map<Integer, Node<Integer>> nodeMap) {
        if (root == null) {
            return;
        }
        nodeMap.put(level, root);
        bottomView(root.left, level - 1, nodeMap);
        bottomView(root.right, level + 1, nodeMap);
    }

    public static void printBottomView(Node<Integer> root) {
        Map<Integer, Node<Integer>> nodeMap = new HashMap<>();
        bottomView(root, 0, nodeMap);
        nodeMap.keySet().forEach((level)-> System.out.println(nodeMap.get(level).data));
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
