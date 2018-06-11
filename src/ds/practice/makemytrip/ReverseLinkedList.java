package ds.practice.makemytrip;

public class ReverseLinkedList {

    Node<Integer> head;

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.head = new Node<>(1);
        reverseLinkedList.head.next = new Node<>(2);
        reverseLinkedList.head.next.next = new Node<>(3);
        reverseLinkedList.head.next.next.next = new Node<>(4);
        reverseLinkedList.head.next.next.next.next = new Node<>(5);
        reverseLinkedList.head.next.next.next.next.next = new Node<>(6);

        Node<Integer> newHead = reverseLinkedList.reverseIterative(reverseLinkedList.head);
        System.out.println(newHead.data);
    }

    private Node<Integer> reverseLinkedListRecursive(Node<Integer> head) {
       return reverseRecursive(head,null);
    }

    private Node<Integer> reverseRecursive(Node<Integer> curr, Node<Integer> prev){
        if(curr == null){
            return prev;
        }
        reverseRecursive(curr.next,curr);
        curr.next = prev;
        return null;
    }

    private Node<Integer> reverseIterative(Node<Integer> head){
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        while(curr != null){
            Node<Integer> originalNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = originalNext;
        }
        return prev;
    }


    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
