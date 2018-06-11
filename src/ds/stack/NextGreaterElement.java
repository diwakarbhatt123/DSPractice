package ds.stack;

import java.util.Stack;


/**
 *
 * 1. Push first list element in array.
 * 2. loop the list.
 *    a. Keep poping elements from stack till you can't find element smaller than that.
 *    b. push the last popped element into the stack.
 *    c. push the current list element into the stack.
 *
 *
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        int input[] = new int[]{13, 7, 6, 12};
        findNextGreatest(input);
    }

    private static void findNextGreatest(int[] input) {
        int next;
        int element;
        Stack<Integer> tempStack = new Stack<>();
        tempStack.push(input[0]);
        for (int i = 1; i < input.length; i++) {
            next = input[i];
            if (!tempStack.isEmpty()) {
                element = tempStack.pop();
                while (element < next) {
                    System.out.println(element + "-->" + next);
                    if (tempStack.isEmpty()) {
                        break;
                    }
                    element = tempStack.pop();
                }

                if (element > next) {
                    tempStack.push(element);
                }
                tempStack.push(next);
            }
        }
        while (!tempStack.isEmpty()) {
            element = tempStack.pop();
            next = -1;
            System.out.println(element + "-->" + next);
        }
    }
}
