package ds.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MergeSortLinkedList {

    public static void main(String[] args) {

        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();

        Node<Integer> firstNode = mergeSortLinkedList.createUnsortedLinkedList();

        Node<Integer> sortedFirstElement = mergeSortLinkedList.mergeSortLinkedList(firstNode);

        printLinkedList(sortedFirstElement);

    }

    private static void printLinkedList(Node<Integer> sortedFirstElement) {
        Node<Integer> currentPointer = sortedFirstElement;
        while (Objects.nonNull(currentPointer)){
            System.out.print(currentPointer.getElement()+(Objects.nonNull(currentPointer.getNext())?"->":""));
            currentPointer = currentPointer.getNext();
        }
    }

    private Node<Integer> mergeSortLinkedList(Node<Integer> firstNode) {

        if (Objects.isNull(firstNode) || Objects.isNull(firstNode.getNext())) {
            return firstNode;
        } else {
            Node<Integer> middleElement = findMiddleElement(firstNode);
            Node<Integer> nextOfMiddle = middleElement.getNext();
            middleElement.setNext(null);
            Node<Integer> left = mergeSortLinkedList(firstNode);
            Node<Integer> right = mergeSortLinkedList(nextOfMiddle);
            return sortedMerge(left, right);
        }

    }

    private Node<Integer> sortedMerge(Node<Integer> middleElement, Node<Integer> next) {
        Node<Integer> result;
        if (Objects.isNull(middleElement)) {
            return next;
        } else if (Objects.isNull(next)) {
            return middleElement;
        }
        if (middleElement.getElement() < next.getElement()) {
            result = middleElement;
            result.setNext(sortedMerge(middleElement.getNext(), next));
        } else {
            result = next;
            result.setNext(sortedMerge(middleElement, next.getNext()));
        }
        return result;
    }

    private Node<Integer> findMiddleElement(Node<Integer> firstNode) {
        Node<Integer> mainPointer = firstNode;
        Node<Integer> referencePointer = firstNode.getNext();

        while (Objects.nonNull(referencePointer) && Objects.nonNull(referencePointer.getNext())) {
            mainPointer = mainPointer.getNext();
            referencePointer = referencePointer.getNext().getNext();
        }

        return mainPointer;
    }


    private Node<Integer> createUnsortedLinkedList() {
        Node<Integer> firstNode = null;
        Node<Integer> currentNode = null;
        List<Integer> numbers = Arrays.asList(2, 1, 4, 3, 6, 5);
        for (Integer val : numbers) {
            if (Objects.isNull(firstNode)) {
                firstNode = new Node<>();
                firstNode.setElement(val);
                firstNode.setNext(null);
                currentNode = firstNode;
            } else {
                Node<Integer> nextNode = new Node<>();
                nextNode.setElement(val);
                nextNode.setNext(null);
                currentNode.setNext(nextNode);
                currentNode = nextNode;
            }

        }
        return firstNode;
    }


    class Node<T> {
        private T element;
        private Node<T> next;

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
