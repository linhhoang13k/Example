package com.ctci.chapter2;

import com.ctci.library.Node;

/**
 * Created by zambro on 4/8/17.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * * Ex: 3-5-8-5-10-2-1 becomes for x =5
 *
 * 3-1-2-10-5-5-8
 */
public class Partition {

    public static Node partition(Node head, int x) {
        Node h = null, t = null;

        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.next = null;
             if(current.data < x) {
                 //Add it to head;
                 if(h == null) {
                     h = current;
                     t = current;
                 } else {
                     current.next = h;
                     h = current;
                 }
             } else {
                 //Add it to tail
                 if(t == null) {
                     t = current;
                     h = current;
                 } else {
                     t.next = current;
                     t = current;
                 }
             }
             current = next;
        }
        return h;
    }
    public static void main(String[] args) {
        Node n = new Node(1);
        n = new Node(2, n);
        n = new Node(10, n);
        n = new Node(5, n);
        n = new Node(8, n);
        n = new Node(5, n);
        n = new Node(3, n);

        n.printAll();
        n = partition(n, 5);
        n.printAll();
    }
}
