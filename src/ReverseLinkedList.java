package edu.learning.codefights.linkedlist;

/**
 * Created by duchuunguyen on 7/28/17.
 */
public class ReverseLinkedList {
    public static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        int length = length(l);
        int cIndex = 0;
        ListNode<Integer> result = null;
        ListNode<Integer> prevNode = null; // ==> to reverse
        ListNode<Integer> pTail = null;
        ListNode<Integer> cTail = null; // ==> save the tail to attach the head of next reversed list

        while (l != null) {
            if (length / k > cIndex / k) {
                // reverse
                if (cIndex % k == 0) {
                    //set tail
                    cTail = l;
                    prevNode = l;
                    l = l.next;
                    cTail.next = null;
                } else {
                    ListNode<Integer> nextNode = l.next;
                    l.next = prevNode;
                    prevNode = l;
                    l = nextNode;
                }
                if (cIndex % k == k -1 ) {
                    if (result == null) {
                        result = prevNode;
                    } else {
                        pTail.next = prevNode;
                    }
                    pTail = cTail;
                }
            } else {
                cTail.next = l;
                break;
            }
            cIndex++;
        }
        return result;
    }

    // O(n)
    private static int length(ListNode l) {
        if (l == null) {
            return 0;
        }
        int length = 1;
        while (l.next != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode<Integer> node0 = new ListNode<Integer>(1);
        ListNode<Integer> node1 = new ListNode<Integer>(2);
        ListNode<Integer> node2 = new ListNode<Integer>(3);
        ListNode<Integer> node3 = new ListNode<Integer>(4);
        ListNode<Integer> node4 = new ListNode<Integer>(5);
        ListNode<Integer> node5 = new ListNode<Integer>(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode<Integer> r = reverseNodesInKGroups(node0, 3);
        System.out.println();
    }
}
