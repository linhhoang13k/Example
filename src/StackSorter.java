package com.ctci.chapter3;

import java.util.Stack;

/**
 * Created by zambro on 4/15/17.
 */
public class StackSorter {

    public static void getSortedStack(Stack<Integer> stack) {
        Stack<Integer> cacheStack = new Stack<>();
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            while(!cacheStack.isEmpty() && cacheStack.peek() > temp) {
                stack.push(cacheStack.pop());
            }
            cacheStack.push(temp);
        }

        while(!cacheStack.isEmpty())
            stack.push(cacheStack.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        System.out.println(stack);
        getSortedStack(stack);
        System.out.println(stack);

        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random()*100);
            s.push(r);
        }
        System.out.println(s);
        getSortedStack(s);
        System.out.println(s);

    }
}
