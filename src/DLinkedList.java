import java.util.*;

public class DLinkedList<T> implements List<T>, Iterable<T> {
    private class Node{
        T data;
        private Node prev;
        private Node next;

        public Node(T data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node tail;  

    public DLinkedList() {
        head = null;
        tail = null;
    }
    
}
