package com.ctci.chapter2;

import com.ctci.library.Node;

/**
 * Created by zambro on 4/8/17.
 * Find Kth to the last
 *
 * Ex: 1-2-3-2-1-5-3
 *
 * K= 3 should return 1;
 */
public class ReturnKthToLast {

    public static Node findKthToLast(Node head, int k) {
        Node fwd = head;
        Node pointer = head;

        while(k>0 && fwd != null) {
            fwd = fwd.next;
            k--;
        }

        if(fwd == null)
            return null;

        while(fwd != null) {
            pointer = pointer.next;
            fwd = fwd.next;
        }

        return pointer;
    }
    public static void main(String[] args) {
        Node n = new Node(3);
        n = new Node(5, n);
        n = new Node(1, n);
        n = new Node(2, n);
        n = new Node(3, n);
        n = new Node(2, n);
        n = new Node(1, n);

        n.printAll();
        Node i = findKthToLast(n, 20);
        System.out.println(i==null?i:i.data);
    }
}
