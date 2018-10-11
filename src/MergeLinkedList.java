package edu.learning.codefights.linkedlist;

/**
 * Created by duchuunguyen on 7/21/17.
 */
public class MergeLinkedList {
    public static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> head = new ListNode<Integer>(0);
        ListNode<Integer> current = head;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                ListNode<Integer> l1Next = l1.next;
                current.next = l1;
                current = l1;
                l1 = l1Next;
            } else {
                ListNode<Integer> l2Next = l2.next;
                current.next = l2;
                current = l2;
                l2 = l2Next;
            }
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head.next;
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
        ListNode<Integer> nodeA = new ListNode<Integer>(1);
        ListNode<Integer> node1 = new ListNode<Integer>(5);
        ListNode<Integer> node2 = new ListNode<Integer>(6);

        ListNode<Integer> nodeB = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);

        nodeA.next = node1;
        node1.next = node2;

        nodeB.next = node3;
        node3.next = node4;

        mergeTwoLinkedLists(nodeA, nodeB);
        System.out.println();
    }
}
