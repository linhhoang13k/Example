package com.ctci.chapter3;

import java.util.Stack;

/**
 * Created by zambro on 4/15/17.
 */
public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(int data) {
        stack1.add(data);
    }

    public int remove(){
        if(stack2.isEmpty()) {
            //Move all elements from stack 1 to 2
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.remove());
        queue.add(40);
        System.out.println(queue.remove());
        queue.add(50);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
