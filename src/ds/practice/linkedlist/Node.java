package ds.practice.linkedlist;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
