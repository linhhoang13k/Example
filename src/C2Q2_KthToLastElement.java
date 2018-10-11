package LinkedList;

import LinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * Created by Trung on 12/13/2017.
 *
 * Problem statement: Implement a method that finds the kth to last element of
 * a singly linked list.
 * Assume: k = 1 ==> return the last element
 *         k = 2 ==> return the second to last element, and so forth.
 *
 * Solution:
 * - Iterative: Using two pointers. First pointer moves to the end of the linked list normally.
 * One pointer moves only when the first one has moved k - 1 times. When first pointer
 * reaches the end, the second pointer points to the correct node.
 */
public class C2Q2_KthToLastElement {

    public static MyLinkedList.Node kthToLastElement(MyLinkedList<Integer> list, int k) {
        if (list == null) return null;
        MyLinkedList.Node<Integer> p1 = list.head;
        MyLinkedList.Node<Integer> p2 = list.head;
        k = k - 1;  //Define above.
        while (p1 != null){
            p1 = p1.getNext();
            if (k == 0)  p2 = p2.getNext();
            else k--;
            if (p1.getNext() == null) {
                if (k == 0) return p2;
                else return null;
            }
        }
        return null;
    }

}
