package ds.linkedlist;

import java.util.Objects;

public class Traversal {


    public static void main(String[] args) {
        Node<Integer> firstNode = createIncrementalLinkedList();
        traverseLinkedList(firstNode);
    }

    private static void traverseLinkedList(Node<Integer> firstNode) {
        Node<Integer> currNode = firstNode;
        do {
            System.out.println(currNode.getValue());
            currNode = currNode.getNext();
        }while (Objects.nonNull(currNode));
    }

    private static Node<Integer> createIncrementalLinkedList() {
        Node<Integer> first = new Node<>();
        first.setValue(1);
        Node<Integer> prev = null;
        for (int i = 2; i < 10; i++) {
            Node<Integer> node = new Node<>();
            node.setValue(i);
            if(Objects.isNull(first.getNext())){
                first.setNext(node);
            }else {
                prev.setNext(node);
            }
            prev = node;
        }
        return first;
    }


    static class Node<T>{
        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }


}
