package ds.stack;

import java.util.Stack;

/**
 * n a party of N people, only one person is known to everyone.
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 * We can only ask questions like “does A know B? “.
 * Find the stranger (celebrity) in minimum number of questions.
 *
 *  *********SOLUTION*************
 * 1. Pushed all values into stack.
 * 2. Pop first two values a and b.
 *    loop while stack has single value left.
 * 3. If a knows b then a can't be celebrity discard a and push b.
 * 4. If a don't know b then b can't be celebrity discard b and push a.
 *    loop ends
 * 5. Last man remaining is celebrity(should check if it doesn't knows any other member)
 *
 *
 */
public class TheCelebrityProblem {

    // Returns true if a knows b, false otherwise
    private static boolean knows(int a, int b)
    {
        int MATRIX[][] = { { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 }
                                         };

        return MATRIX[a][b] == 1;
    }

    public static void main(String[] args) {
        System.out.println(findCelebrity(4) + " is Celebrity");
    }

    private static int findCelebrity(int n) {
        Stack<Integer> celebrityStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            celebrityStack.push(i);
        }
        while (celebrityStack.size() > 1){
            int a = celebrityStack.pop();
            int b = celebrityStack.pop();
            if(knows(a,b)){
                celebrityStack.push(b);
            }
            else {
                celebrityStack.push(a);
            }
        }
        return celebrityStack.pop();
    }

}
