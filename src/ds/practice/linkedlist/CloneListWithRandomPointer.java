package ds.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneListWithRandomPointer {

    Node<Integer> head;
    public static void main(String[] args) {
        CloneListWithRandomPointer list = new CloneListWithRandomPointer();
        list.head = new Node<>(1);
        list.head.next = new Node<>(2);
        list.head.next.next = new Node<>(3);
        list.head.next.next.next = new Node<>(4);
        list.head.next.next.next.next = new Node<>(5);
        list.head.random = list.head.next.next;
        list.head.next.random = list.head;
        list.head.next.next.random = list.head.next.next.next.next;
        list.head.next.next.next.random = list.head.next.next;
        list.head.next.next.next.next.random = list.head.next;
        list.cloneListDataMutable(list.head);
    }

    private Node<Integer> cloneListDataNotMutable(Node<Integer> head){
        Map<Node<Integer>,Node<Integer>> nodeNodeMap = new HashMap<>();
        Node<Integer> curr = head;
        Node<Integer> clonedHead = null;
        while (curr != null){
            Node<Integer> cloneNode = new Node<>(curr.data);
            nodeNodeMap.put(curr,cloneNode);
            curr = curr.next;
        }

        curr = head;
        while (curr!= null){
            Node<Integer> clonedNode = nodeNodeMap.get(curr);
            clonedNode.next = nodeNodeMap.get(curr.next);
            clonedNode.random = nodeNodeMap.get(curr.random);
            if(curr == head){
                clonedHead = clonedNode;
            }
            curr = curr.next;
        }
        return clonedHead;
    }

    private Node<Integer> cloneListDataMutable(Node<Integer> head){
        Node<Integer> currOriginal = head;
        Node<Integer> prevCloned = null;
        while (currOriginal != null){
            Node<Integer> clonedNode = new Node<>(currOriginal.data);
            if(prevCloned!= null) {
                prevCloned.next = clonedNode;
            }
            Node<Integer> originalNext = currOriginal.next;
            currOriginal.next = clonedNode;
            clonedNode.random = currOriginal;
            prevCloned = clonedNode;
            currOriginal = originalNext;
        }

        //Set up arbitory pointers
        Node<Integer> clonedListCurrent = head.next;
        while (clonedListCurrent != null){
            clonedListCurrent.random = clonedListCurrent.random.random.next;
            clonedListCurrent = clonedListCurrent.next;
        }
        return currOriginal;
    }


    public Node<Integer> cloneWithoutExtraSpace(Node<Integer> head){
       Node<Integer> currentNode = head;
       while (currentNode!=null){
           Node<Integer> cloneNode = new Node<>(currentNode.data);
           Node<Integer> originalNext = currentNode.next;
           currentNode.next = cloneNode;
           cloneNode.next = originalNext;
           currentNode = originalNext;
       }
       return currentNode;
    }

    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> random;

        public Node(T data) {
            this.data = data;
        }
    }

}
