package ds.practice.linkedlist;

public class ReverseLinkList {

    Node<Integer> head;

    public static void main(String[] args) {
        ReverseLinkList list = new ReverseLinkList();
        list.head = new Node<>(50);
        list.head.next = new Node<>(20);
        list.head.next.next = new Node<>(15);
        list.head.next.next.next = new Node<>(4);
        list.head.next.next.next.next = new Node<>(10);
        list.head.next.next.next.next.next = list.head;
//        list.reverseLinkedListRecursive(list.head, null);
        list.detectAndRemoveLoop(list.head);
        System.out.println(list.head);
    }

    public Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> next;
        Node<Integer> prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reverseLinkedListRecursive(Node<Integer> curr, Node<Integer> prev) {
        if (curr.next != null) {
            reverseLinkedListRecursive(curr.next, curr);
        } else {
            head = curr;
        }
        curr.next = prev;
    }


    public Node<Integer> mergeSortLinkedList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> middleNode = findMiddle(head);
        Node<Integer> nextOfMiddle = middleNode.next;
        middleNode.next = null;
        Node<Integer> leftNodes = mergeSortLinkedList(head);
        Node<Integer> rightNodes = mergeSortLinkedList(nextOfMiddle);
        return sortMerge(leftNodes, rightNodes);
    }

    private Node<Integer> findMiddle(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        Node<Integer> fastPointer = head.next;
        Node<Integer> slowPointer = head;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    private Node<Integer> sortMerge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.data < right.data) {
            result = left;
            result.next = sortMerge(left.next, right);
        } else {
            result = right;
            result.next = sortMerge(left, right.next);
        }
        return result;
    }


    public void detectAndRemoveLoop(Node<Integer> head){
        Node<Integer> slowPointer = head.next;
        Node<Integer> fastPointer = head.next.next;
        while (fastPointer != null){
            if(fastPointer == slowPointer){
                break;
            }
            fastPointer = fastPointer.next;
            if(fastPointer != null){
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        if(fastPointer == slowPointer){
            slowPointer = head;
            while (fastPointer.next != slowPointer.next){
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
            fastPointer.next = null;
        } else {
            System.out.println("No loop found");
        }
    }
}
