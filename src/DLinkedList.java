import java.util.*;

/**
 *  Doubly Linked List Class implements Iterable and List classes.
 * @param <T>
 */
public class DLinkedList<T> implements List<T>, Iterable<T> {
    /**
     * This method overrides the addfirst method of the List class and allows the user to add an element to their DLinkedList
     * @param data
     */
    @Override
    public void addFirst(T data) { //This adds an item to the front of the DLinked List
        head = new Node(data, head, null);// create new node for head with data of input
        Node second = head.next; //create node of second being the next node after head,
        if (second != null){ // if second index is null, set head to the previous of second
            second.prev = head;
        }
        else {
            tail = head; // otherwise this is an empty list node and head is the same as tail
        }
    }

    /**
     * This method checks whether an 'item' exists within an object of a generic class, this is again an override of the List class method
     * @param item
     * @return Boolean of whether or not the item exists in the object
     */
    @Override
    public boolean contains(T item) {
        if (head == null) { //if the head is empty, the list is empty, so it does not contain anything, so return false
            return false;
        } else if (head.data.equals(item)) { //if the first value is the same as the value being searched for then the method returns true
            return true;
        }
        Node temp = head; // temporary node
        while (temp.next != null) { // iterate through to check all data if there is any that match the inputted item
            if (temp.data.equals(item)) {
                return true;
            } else if (temp.next.data.equals(item)) {
                return true;
            } else  if (temp.prev != null && temp.prev.data.equals((item))){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * This method returns the size of the list, override of the list class method
     * @return int of the size of the list
     */
    @Override
    public int size() {
        int count = 0; //creating count var to be size of DLinkedList
         // creating 'iterator' object
        while(head != null){ //while the iterator has the next value...
            count++; //add 1 to the count
            head = head.next;
        }
        return count; //once the iterator has no more values, return count to output the size of the list
    }

    /**
     * This method checks whether a list is empty or not
     * @return Boolean if list is empty or not
     */
    @Override
    public boolean isEmpty() {

        if (head == null) {//check if list is empty or the first value is null
            return true; // the list is empty
        } else {
            return false;//otherwise the list is not empty, return false
        }
    }

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
    T data;
    Node head;
    Node tail;

    public DLinkedList() {
        head = null;
        tail = null;
    }
    /**
     * overrides iterator method of Iterator class method
     * @return object of T class from Iterator
     */
    public class DListIterator extends DLinkedList<T> implements Iterator<T>{//this is a class of the iterator so the methods of the iterator can be used
        private Node nextNode = head;
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iter exceeded");
            }
            T data = nextNode.data;
            nextNode = nextNode.next;
            return data;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new DListIterator();
    }
    @Override
    public String toString() {
        return head.toString();
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

