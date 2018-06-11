package ds.practice.trees;

import java.util.*;

public class DFSTraversals {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.right.left = new Node<>(6);
        root.left.right.right = new Node<>(7);
        root.right.right = new Node<>(8);
        root.right.right.right = new Node<>(9);
        root.right.right.right.left = new Node<>(10);
        root.right.right.right.right = new Node<>(11);
        root.right.right.right.left.right = new Node<>(12);
//        Node<Integer> root = new Node<>(4);
//        root.left = new Node<>(2);
//        root.right = new Node<>(1);
//        root.left.left = new Node<>(8);
//        root.left.right = new Node<>(10);
//        root.right.left = new Node<>(12);
//        root.right.right = new Node<>(24);
        System.out.println(diameterOfTree(root));
     }

    public static void inOrderTraversalRecursion(Node<Integer> root) {
        if (root == null) {
            return;
        }
        inOrderTraversalRecursion(root.left);
        inOrderTraversalRecursion(root.right);
        System.out.println(root.data);
    }

    public static void inOrderTraversalWithoutRecursion(Node<Integer> root) {
        Stack<Node<Integer>> nodeStack = new Stack<>();
        Node<Integer> curr = root;
        while (!nodeStack.isEmpty() || curr != null) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            if (!nodeStack.isEmpty()) {
                Node<Integer> poppedNode = nodeStack.pop();
                System.out.println(poppedNode.data);
                curr = poppedNode.right;
            }
        }
    }

    public static void morrisTraversalInOrder(Node<Integer> root) {
        Node<Integer> current = root;
        Node<Integer> pre = null;
        while (current != null) {
            if (current.left != null) {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            } else {
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    public static void printPreOrderTraversalWithoutRecursion(Node<Integer> root) {
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> poppedNode = stack.pop();
            System.out.println(poppedNode.data);
            if (poppedNode.right != null) {
                stack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                stack.push(poppedNode.left);
            }
        }
    }

    public static void printPostOrderTraversalWithoutRecusrion(Node<Integer> root) {
        Stack<Node<Integer>> preorderStack = new Stack<>();
        Stack<Node<Integer>> postOrderStack = new Stack<>();
        preorderStack.push(root);
        while (!preorderStack.isEmpty()) {
            Node<Integer> poppedNode = preorderStack.pop();
            postOrderStack.push(poppedNode);
            if (poppedNode.left != null) {
                preorderStack.push(poppedNode.left);
            }
            if (poppedNode.right != null) {
                preorderStack.push(poppedNode.right);
            }
        }
        while (!postOrderStack.isEmpty()) {
            System.out.println(postOrderStack.pop().data);
        }
    }

    public static void printPostOrderTraversalWithoutRecursionAndTwoStacks(Node<Integer> root) {
        Stack<Node<Integer>> nodeStack = new Stack<>();
        nodeStack.push(root.right);
        nodeStack.push(root);
        root = root.left;
        while (!nodeStack.isEmpty()) {
            while (root != null) {
                if (root.right != null) {
                    nodeStack.push(root.right);
                }
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            if (root.right != null && root.right.equals(nodeStack.peek())) {
                nodeStack.pop();
                nodeStack.push(root);
                root = root.right;
            } else {
                System.out.println(root.data);
                root = null;
            }
        }
    }

    public static void printTreeDiagonally(Node<Integer> root) {
        Map<Integer, List<Node<Integer>>> nodeListMap = new HashMap<>();
        printDigonally(root, 0, nodeListMap);
        nodeListMap.keySet().forEach((slope) -> {
            nodeListMap.get(slope).forEach((node) ->
                    System.out.print(node.data+" "));
            System.out.println();
        });
    }

    private static void printDigonally(Node<Integer> root, int slope, Map<Integer, List<Node<Integer>>> nodeListMap) {
        if (root == null) {
            return;
        }
        List<Node<Integer>> nodeList = nodeListMap.get(slope);
        if (nodeList == null) {
            nodeList = new ArrayList<>();
        }
        nodeList.add(root);
        nodeListMap.put(slope, nodeList);
        printDigonally(root.left, slope + 1, nodeListMap);
        printDigonally(root.right, slope, nodeListMap);
    }


    public static void boundryTraversal(Node<Integer> root){
        System.out.println(root.data);
        printLeftBoundryTopDown(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundryBottomUp(root.right);
    }

    private static void printLeftBoundryTopDown(Node<Integer> root){
        if(root== null){
            return;
        }
        System.out.println(root.data);
        printLeftBoundryTopDown(root.left);
    }
    private static void printRightBoundryBottomUp(Node<Integer> root){
        if(root==null){
            return;
        }
        printRightBoundryBottomUp(root.right);
        System.out.println(root.data);
    }
    private static void printLeaves(Node<Integer> root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            System.out.println(root.data);
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static int diameterOfTree(Node<Integer> root){
        Integer height = 0;
        int leftHeight = heightOfTree(root.left,height);
        int rightHeight = heightOfTree(root.right,height);
        return leftHeight+rightHeight+1;
    }

    private static int heightOfTree(Node<Integer> root,Integer height){
        if(root == null){
            return height;
        }
        int lHeight = heightOfTree(root.left,height+1);
        int rHeight = heightOfTree(root.right,height+1);
        return Math.max(lHeight,rHeight);
    }
}
