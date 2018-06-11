package ds.queue;

import java.util.Stack;

public class QueueUsingStack<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void enqueue(T value){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public T dequeue(){
        return stack1.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> integerQueueUsingStack = new QueueUsingStack<>();
        integerQueueUsingStack.enqueue(1);
        integerQueueUsingStack.enqueue(2);
        integerQueueUsingStack.enqueue(3);
        integerQueueUsingStack.enqueue(4);
        System.out.println(integerQueueUsingStack.dequeue());
        System.out.println(integerQueueUsingStack.dequeue());
        System.out.println(integerQueueUsingStack.dequeue());
        System.out.println(integerQueueUsingStack.dequeue());
    }

}
