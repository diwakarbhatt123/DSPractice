package ds.linkedlist;

public class TestImplementation {

    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList1 = new CustomLinkedList<>();
        customLinkedList1.addElement(1);
        customLinkedList1.addElement(2);
        customLinkedList1.addElement(3);
        customLinkedList1.addElement(4);
        customLinkedList1.addElement(5);
        customLinkedList1.addElement(6);
        customLinkedList1.addElement(7);
        customLinkedList1.addElement(8);
        customLinkedList1.addElement(9);
        customLinkedList1.reverseInGroup(3);
    }
}
