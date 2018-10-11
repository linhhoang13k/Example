package com.il.training.hackerrank.ctci;

/**
 * Created by cesaregb on 12/2/16.
 */
public class DetectCycle {

  boolean hasCycle(Node head) {
    if (head == null || head.next == null) return false;
    Node fast = head.next;
    while (head != fast) {
      // compare nodes... does the node has a equals implemented?
      if (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
      } else {
        return false;
      }
      head = head.next;
    }
    return true;
  }

  class Node {
    int data;
    Node next;
  }
}
