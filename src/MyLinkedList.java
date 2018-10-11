package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Trung on 6/27/2017.
 */
public class MyLinkedList<E> {

    protected Node<E> head;

    protected Node<E> tail;

    protected int size;

    public MyLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }

    public void deleteEnd() {
        Node curr = head;
        if (head == null) return;
        while (curr.next != null && curr.next != tail) {
            curr = curr.next;
        }
        tail = curr;
        curr.next = null;
        size--;

    }

    public void removeAtIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
            if (size == 1)
                tail = null;
        }
        else {
            Node<E> current = nodeAt(index - 1);
            current.next = current.next.next;
            if (current.next == null)
               tail = current;
        }

        size--;
    }

    public void remove(E value) {
        int location = getIndex(value);
        removeAtIndex(location);
    }

    public void delete(E data) {
        Node curr = head;
        if (head == null) return;
        if (head.data == data) {
            head = head.next;

            size--;
        } else {
            while (curr.next != null) {
                if (curr.next.data == data) {
                    curr.next = curr.next.next;
                    size--;
                    return;
                }
                curr = curr.next;
            }
        }
    }

    public int getIndex(E value) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new MyListIterator();
    }
    @Override
    public String toString() {
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.data + " ");
            curr = curr.next;
        }
        return sb.toString();
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private Node<E> nodeAt(int index) {
        Node<E> current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyListIterator implements Iterator<E> {

        private Node<E> curr;

        private Node<E> prev;

        private int index;

        private boolean removeOK;

        public MyListIterator() {
            curr = head;
            prev = null;
            removeOK = false;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Element does not exist.");
            }
            prev = curr;
            E result = curr.data;
            curr = curr.next;
            removeOK = true;
            index++;
            return result;
        }

        public Node<E> getCurr() {
            return this.curr;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException("Cannot remove this element.");
            }
            //TODO
            MyLinkedList.this.removeAtIndex(index - 1);
            removeOK = false;

        }
    }



    /**
     * Created by Trung on 6/27/2017.
     */
    public static class Node<E> {
        private E data;

        private Node next;

        public Node(E arg) {
            data = arg;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node<E> node) {
            next = node;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
