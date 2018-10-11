package com.ctci.library;

import java.util.EmptyStackException;

/**
 * Created by zambro on 4/14/17.
 */
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        private QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> node = new QueueNode<T>(data);
        if(last != null) {
            last.next = node;
        }
        last = node;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) throw new EmptyStackException();
        T data = first.data;
        if(first == last) {
            last = null;
        }
        first = first.next;
        return data;
    }

    public T peek() {
        if(first == null) throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
