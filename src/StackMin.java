package com.ctci.chapter3;

import com.ctci.library.MyStack;

/**
 * Created by zambro on 4/15/17.
 */
public class StackMin {

    private static class StackMinimum extends  MyStack<Integer> {
        private MyStack<Integer> stack;

        public StackMinimum(){
            stack = new MyStack<>();
        }

        @Override
        public void push(Integer data) {
            super.push(data);
            if(data <= min())
                stack.push(data);
        }

        @Override
        public Integer pop() {
            int data = super.pop();
            if(data == min())
                stack.pop();
            return data;
        }

        public Integer min() {
            if(stack.isEmpty())
                return Integer.MAX_VALUE;
            else
                return stack.peek();
        }
    }


    public static void main(String[] args) {
        StackMinimum stack = new StackMinimum();
        stack.push(5);
        System.out.println("Current Min: "+stack.min());
        stack.push(6);
        System.out.println("Current Min: "+stack.min());
        stack.push(3);
        System.out.println("Current Min: "+stack.min());
        stack.push(7);
        System.out.println("Current Min: "+stack.min());

        System.out.println(stack.pop());
        System.out.println("Current Min: "+stack.min());
        System.out.println(stack.pop());
        System.out.println("Current Min: "+stack.min());
        System.out.println(stack.pop());
        System.out.println("Current Min: "+stack.min());
        System.out.println(stack.pop());
        System.out.println("Current Min: "+stack.min());


    }
}
