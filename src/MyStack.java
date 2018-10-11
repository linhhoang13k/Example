package com.ctci.library;

import javax.naming.SizeLimitExceededException;
import java.util.EmptyStackException;

/**
 * Created by zambro on 4/14/17.
 */
public class MyStack<T> {

    private int capacity;

    public int getSize() {
        return size;
    }

    private int size;

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        private StackNode(T data) {
            this.data  = data;
        }
    }

    public MyStack(){}
    public MyStack(int capacity) {
        this.capacity = capacity;
    }

    private StackNode<T> top;
    public void push(T data) {
        if(capacity != 0 && capacity == size)
            throw new ArrayIndexOutOfBoundsException();

        StackNode<T> node = new StackNode<T>(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T data  = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}