import java.util.*;

public class DLinkedList<T> implements List<T>, Iterable<T> {
    @Override
    public void addFirst(T item) { //This adds an item to the front of the DLinked List
        head = new Node(item, head, null);
        Node second = head.next;
        if (second != null){ // at least one node exits if this is not 'null'
            second.prev = head; // thus the new item becomes the first item and the previous to the first become the second
        } else {
            tail = head; //otherwise both head and tail point to the first node
        }
    }

    @Override
    public boolean contains(T item) {
        Boolean result = null; //creating variable for result of search
        while (iterator().hasNext()){ //checking if iterator has a next item
            if (iterator().next() == item){ //checking if next item is in face the item in question
                result = true; //if it is, set return var to 'true'
            }
            else {
                result = false; //otherwise, it's false since that is not the item in question
            }
        }
        return result; //return statement
    }

    @Override
    public int size() {
        int count = 0; //creating count var to be size of DLinkedList
        while(iterator().hasNext()){ //while the iterator has the next value...
            count++; //add 1 to the count
        }
        return count; //once the iterator has no more values, return count to output the size of the list
    }

    @Override
    public boolean isEmpty() {
        if (iterator().hasNext() == false){//if the iterator does not have a next value, then the list is empty, thus, we return true
            return true;
        } else{ //otherwise, the list is not empty and we return false
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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

    Node head;
    Node tail;  

    public DLinkedList() {
        head = null;
        tail = null;
    }
    
}
