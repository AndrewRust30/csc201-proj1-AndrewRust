import java.util.*;

/**
 *  Doubly Linked List Class implements Iterable and List classes.
 * @param <T>
 */
public class DLinkedList<T> implements List<T>, Iterable<T> {
    /**
     * This method overrides the addfirst method of the List class and allows the user to add an element to their DLinkedList
     * @param item
     */
    @Override
    public void addFirst(T item) { //This adds an item to the front of the DLinked List
        Node newNode = new Node(item, head, null);
        if (head == null){ //if the list is empty
            tail = head = newNode; //then both head and tail point to the first node ('newNode')
        } else{ // otherwise head moves to second spot and new node becomes head
            head = head.next;
            newNode = head;
        }
    }

    /**
     * This method checks whether an 'item' exists within an object of a generic class, this is again an override of the List class method
     * @param item
     * @return Boolean of whether or not the item exists in the object
     */
    @Override
    public boolean contains(T item) {
        Boolean result = false; //creating variable for result of search
        Iterator<T> it = iterator(); // creating 'iterator' object
        while (it.hasNext()){ //checking if iterator has a next item
            if (it.next() == item){ //checking if next item is in face the item in question
                result = true; //if it is, set return var to 'true'
            }
            else {
                result = false; //otherwise, it's false since that is not the item in question
            }
        }
        return result; //return statement
    }

    /**
     * This method returns the size of the list, override of the list class method
     * @return int of the size of the list
     */
    @Override
    public int size() {
        int count = 0; //creating count var to be size of DLinkedList
        Iterator<T> it = iterator(); // creating 'iterator' object
        while(it.hasNext()){ //while the iterator has the next value...
            count++; //add 1 to the count
        }
        return count; //once the iterator has no more values, return count to output the size of the list
    }

    /**
     * This method checks whether a list is empty or not
     * @return Boolean if list is empty or not
     */
    @Override
    public boolean isEmpty() {
        Iterator<T> it = iterator(); // creating 'iterator' object
        if (it.hasNext()){//if the iterator does not have a next value, then the list is empty, thus, we return true
            return true;
        } else{ //otherwise, the list is not empty and we return false
            return false;
        }
    }

    /**
     * overrides iterator method of Iterator class method
     * @return object of T class from Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
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
    
}
