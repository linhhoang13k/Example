package com.ctci.chapter2;

import java.util.HashSet;
import java.util.Set;
import com.ctci.library.*;

/**
 * Created by zambro on 4/8/17.
 * Remove duplicates from linked list.
 *
 * 1-2-3-2-1-5-3 should be
 * 1-2-3-5
 */
public class RemoveDuplicatesFromLinkedList {

    public static Node removeDuplicatesUsingHashSet(Node head) {
        if(head == null)
            return null;

        Node current = head;
        Set<Integer> set = new HashSet<>();
        set.add(current.data);
        while(current.next != null) {
            //Check if current.next's data is in set
            if(set.contains(current.next.data)) {
                //IF yes, then point current.next to current.next's next;
                current.next = current.next.next;
            } else {
                set.add(current.next.data);
                current = current.next;
            }
        }

        return head;
    }

    public static Node removeDuplicates(Node head) {
        if (head == null)
            return null;

        Node current = head;
        while(current.next != null) {
            Node fwdPointer = current;

            while(fwdPointer.next != null) {
                if(fwdPointer.next.data == current.data) {
                    fwdPointer.next = fwdPointer.next.next;
                } else {
                    fwdPointer = fwdPointer.next;
                }
            }

            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node n = new Node(3);
        n = new Node(5,n);
        n = new Node(1, n);
        n = new Node(2, n);
        n = new Node(3, n);
        n = new Node(2, n);
        n = new Node(1, n);

        n.printAll();
        n = removeDuplicatesUsingHashSet(n);
        n.printAll();



        n = new Node(3);
        n = new Node(5,n);
        n = new Node(1, n);
        n = new Node(2, n);
        n = new Node(3, n);
        n = new Node(2, n);
        n = new Node(1, n);

        n.printAll();
        n = removeDuplicates(n);
        n.printAll();
    }


}
