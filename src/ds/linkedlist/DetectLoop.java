package ds.linkedlist;

public class DetectLoop {

    public static void main(String[] args) {
        DetectLoop detectLoop = new DetectLoop();

        Node<Integer> firstNode = detectLoop.createLoopedLinkedList();

        System.out.println(detectLoop.findLoop(firstNode));
    }

    private boolean findLoop(Node<Integer> first) {
        Node<Integer> fastPointer = first;
        Node<Integer> slowPointer = first;
        while (fastPointer.getNext() != null && slowPointer.getNext() != null){
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
            if(fastPointer == slowPointer){
                return true;
            }
        }
        return false;
    }

    private Node<Integer> createLoopedLinkedList() {

        Node<Integer> node1 = new Node<>();
        Node<Integer> node2 = new Node<>();
        Node<Integer> node3 = new Node<>();
        Node<Integer> node4 = new Node<>();
        Node<Integer> node5 = new Node<>();
        node1.setElement(1);
        node1.setNext(node2);
        node2.setElement(2);
        node2.setNext(node3);
        node3.setElement(3);
        node3.setNext(node4);
        node4.setElement(4);
        node4.setNext(node5);
        node5.setElement(5);
        node5.setNext(node2);

        return node1;
    }


    class Node<T> {
        T element;
        Node<T> next;

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
