package ds.tree;

import java.util.*;

/**
 *           1
 *          / \
 *         2  3
 *        /\ /\
 *       4 5 6 7
 *           \ \
 *           8  9
 */
public class VerticalTraversing {

    public static void main(String[] args) {
        Node<Integer> tree = new Node<>(1);
        tree.left = new Node<>(2);
        tree.right = new Node<>(3);

        tree.left.left = new Node<>(4);
        tree.left.right = new Node<>(5);

        tree.right.left = new Node<>(6);
        tree.right.right = new Node<>(7);

        tree.right.left.right = new Node<>(8);
        tree.right.right.right = new Node<>(9);
        printLevelOrder(tree);
    }


    public static void printLevelOrder(Node<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<Node<Integer>> nodes = new LinkedList<>();
        root.level = 0;
        nodes.add(root);
        Map<Integer, ArrayList<Node<Integer>>> map = new HashMap<>();
        int min = 0, max = 0;
        while (!nodes.isEmpty()) {
            Node<Integer> node = nodes.poll();
            int currentLevel = node.level;
            if (node.left != null) {
                node.left.level = currentLevel-1;
                nodes.add(node.left);
            }
            if (node.right != null) {
                node.right.level = currentLevel+1;
                nodes.add(node.right);
            }

            ArrayList<Node<Integer>> levelList = map.get(currentLevel);
            if (levelList != null) {
                levelList.add(node);
            } else {
                ArrayList<Node<Integer>> list = new ArrayList<>();
                list.add(node);
                map.put(currentLevel, list);
            }
            max = Math.max(currentLevel, max);
            min = Math.min(currentLevel, min);
        }

        for (int i = min; i <=max; i++) {
            map.get(i).forEach((integerNode)-> System.out.println(integerNode.data));
        }
    }

    static class Node<T> {
        T data;
        Node<T> left, right;
        int level;

        public Node(T data) {
            this.data = data;
        }
    }

}
