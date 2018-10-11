package com.ctci.chapter2;

import com.ctci.library.Node;

import java.util.Stack;

/**
 * Created by zambro on 4/9/17.
 */
public class PalindromeValidator {

    public static boolean isPalindromeUsingStack(Node head) {
        Node slowPointer = head, fastPointer = head;

        Stack<Integer> stack = new Stack<>();
        while(fastPointer != null && fastPointer.next != null) {
            stack.push(slowPointer.data);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //Take care of odd length
        if(fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        //By now the slowPointer is at the middle + 1
        while(slowPointer != null) {
            if(slowPointer.data != stack.pop()){
                return false;
            }
            slowPointer = slowPointer.next;
        }


        return true;
    }

    public static void main(String[] args) {

        {
            Node n = new Node(1);
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(10, n);
            n = new Node(3, n);
            n = new Node(2, n);
            n = new Node(1, n);
            Node list1 = n;
            list1.printAll();
            System.out.println(isPalindromeUsingStack(list1));
        }
        {
            Node n = new Node(1);
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(3, n);
            n = new Node(2, n);
            n = new Node(1, n);
            Node list1 = n;
            list1.printAll();
            System.out.println(isPalindromeUsingStack(list1));
        }
        {
            Node n = new Node(1);
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(10, n);
            n = new Node(3, n);
            n = new Node(21, n);
            n = new Node(1, n);
            Node list1 = n;
            list1.printAll();
            System.out.println(isPalindromeUsingStack(list1));
        }
        {
            Node n = new Node(1);
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(3, n);
            n = new Node(21, n);
            n = new Node(1, n);
            Node list1 = n;
            list1.printAll();
            System.out.println(isPalindromeUsingStack(list1));
        }

    }


}
