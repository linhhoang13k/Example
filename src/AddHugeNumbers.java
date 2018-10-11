package edu.learning.codefights.linkedlist;

/**
 * Created by duchuunguyen on 7/21/17.
 */
public class AddHugeNumbers {
    public static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> ra = reverse(a);
        ListNode<Integer> rb = reverse(b);

        int remember = 0;
        ListNode<Integer> prev = null;
        while (ra != null || rb != null) {
            ListNode<Integer> sum = new ListNode<Integer>(((ra != null ? ra.value : 0) + (rb != null ? rb.value : 0) + remember) % 10000);
            remember = ((ra != null ? ra.value : 0) + (rb != null ? rb.value : 0) + remember) / 10000;
            sum.next = prev;
            prev = sum;

            ra = ra != null ? ra.next : null;
            rb = rb != null ? rb.next : null;
        }
        if (remember > 0) {
            ListNode<Integer> sum = new ListNode<Integer>(remember);
            sum.next = prev;
            return sum;
        }
        return prev;
    }

    public static ListNode<Integer> reverse(ListNode<Integer> l) {
        ListNode<Integer> prev = null;
        ListNode<Integer> head = l;
        while (head != null) {
            ListNode<Integer> nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode<Integer> nodeA = new ListNode<Integer>(9876);
        ListNode<Integer> node1 = new ListNode<Integer>(5432);
        ListNode<Integer> node2 = new ListNode<Integer>(1999);

        ListNode<Integer> nodeB = new ListNode<Integer>(1);
        ListNode<Integer> node3 = new ListNode<Integer>(8001);

        nodeA.next = node1;
        node1.next = node2;

        nodeB.next = node3;

        addTwoHugeNumbers(nodeA, nodeB);
        System.out.println();
    }
}
