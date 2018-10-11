package com.ctci.chapter3;

import com.ctci.library.MyStack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by zambro on 4/15/17.
 */
public class SetOfStacks {

    List<MyStack<Integer>> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int data) {
        if(stacks.isEmpty() || stacks.get(stacks.size()-1).getSize() == capacity) {
            MyStack<Integer> stack = new MyStack<>(capacity);
            stacks.add(stack);
        }

        stacks.get(stacks.size() - 1).push(data);
    }

    public int pop() {
        if(stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        int data = stacks.get(stacks.size() - 1).pop();
        if(stacks.get(stacks.size() - 1).isEmpty())
            stacks.remove(stacks.size() - 1);

        return data;
    }

    public int getNumberOfStacks(){
        return stacks.size();
    }

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        System.out.println("Total Stacks: "+stacks.getNumberOfStacks());
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        System.out.println("Total Stacks: "+stacks.getNumberOfStacks());
        System.out.println(stacks.pop());
        System.out.println("Total Stacks: "+stacks.getNumberOfStacks());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println("Total Stacks: "+stacks.getNumberOfStacks());
        System.out.println(stacks.pop());
        System.out.println("Total Stacks: "+stacks.getNumberOfStacks());
    }
}
