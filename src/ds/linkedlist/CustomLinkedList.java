package ds.linkedlist;

import java.util.Objects;

public class CustomLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public CustomLinkedList() {
    }


    public void addElement(T element) {
        Node<T> node = new Node<>();
        node.setElement(element);
        if (Objects.isNull(first)) {
            first = node;
            last = first;
        } else {
            node.setNext(last.getNext());
            last.setNext(node);
            last = node;
        }
    }

    public void deleteElement(T element) {
        Node<T> curr = first;
        Node<T> prev = first;
        while (curr != null && curr.getElement() != element) {
            prev = curr;
            curr = curr.getNext();
        }
        if(curr!= null) {
            prev.setNext(curr.getNext());
            curr = null;
        }
    }


    public Node<T> getNthFromLast(int n) {
        Node<T> main = first;
        Node<T> ref = first;
        while (n-- != 0 && main != null) {
            ref = ref.getNext();
        }
        if (main != null) {
            while (main != null && ref != null) {
                ref = ref.getNext();
                main = main.getNext();
            }
        }
        return main;
    }

    public Integer getSize(){
        return size(first,0);
    }

    private Integer size(Node<T> node, int i) {
        if(Objects.isNull(node)){
            return 0;
        }
        return 1 + size(node.getNext(), ++i);
    }

    public Node<T> findMiddle(){
        Node<T> slow = first;
        Node<T> fast = first;
        while ((fast != null && Objects.nonNull(fast.getNext())) && (slow != null && Objects.nonNull(slow.getNext()))){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public void reverseList(){
        reverse(first, first.getNext());
    }

    private void reverse(Node<T> prev, Node<T> curr) {
        if(Objects.isNull(curr)){
            return;
        }
        Node<T> originalPrevious = curr.getNext();
        curr.setNext(prev);
        reverse(curr,originalPrevious);
    }

    public static Node mergeAndSort(CustomLinkedList list1, CustomLinkedList list2){
        Node list1Head = list1.first;
        Node list2Head = list2.first;
        Node temp = new Node();
        while (true){
            if(Objects.isNull(list1)){
                temp.setNext(list2Head);
            }
            if(Objects.isNull(list2)){
                temp.setNext(list1Head);
            }
            if((Integer)list1Head.getElement() <= (Integer) list2Head.getElement()){
                temp.setNext(list1Head);
                list1Head = list1Head.getNext();
            } else {
                temp.setNext(list2Head);
                list2Head = list2Head.getNext();
            }
            temp = temp.getNext();
        }
    }


    public void reverseInGroup(int group){
       first = reverseGroup(first,group);
    }

    private Node<T> reverseGroup(Node<T> first, int group){
        int temp = group;
        Node<T> curr = first;
        Node<T> next = null;
        Node<T> prev = null;

        while (temp-- > 0 && Objects.nonNull(curr)){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        if(Objects.nonNull(next)) {
            first.setNext(reverseGroup(curr, group));
        }
        return prev;
    }

    static class Node<T> {
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
