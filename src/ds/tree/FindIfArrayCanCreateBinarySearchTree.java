package ds.tree;

import java.util.Stack;

public class FindIfArrayCanCreateBinarySearchTree {

    public static void main(String[] args) {
        int inputArr[] = {40, 30, 35, 80, 100};
        System.out.println(canCreateBinaryTree(inputArr));
    }

    public static boolean canCreateBinaryTree(int[] inputArr){
        Stack<Integer> integers = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] < root){
                return false;
            }
            while (!integers.isEmpty() && integers.peek() < inputArr[i]){
                root = integers.pop();
            }
            integers.push(inputArr[i]);
        }
        return true;
    }

}
