package com.il.training.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cesaregb on 1/24/17.
 */
public class LRUCache {

  public static void main(String[] args) {
    LRUCache lru = new LRUCache(2);
    lru.set(2, 1);
    lru.set(1, 1);
    lru.set(2, 3);
    lru.set(4, 1);
    System.out.println(lru.get(1));
    System.out.println(lru.get(2));
  }

  private Map<Integer, Node> nodes = new HashMap<>();
  private int limit = 10;
  private int size = 0;
  private Node head;
  private Node tail;

  private LRUCache(int capacity) {
    this.limit = capacity;
  }

  public int get(int key) {
    Node n = nodes.get(key);
    if (n == null) return -1;
    setHead(n);
    return n.val;
  }

  public void put(int key, int value) {
    set(key, value);
  }

  public void set(int key, int value) {
    Node n = nodes.get(key);
    if (n == null) {
      n = new Node(key, value);
      if (size == 0) {
        tail = n;
      }
      size++;
    }
    n.val = value;
    setHead(n);
    removeTail();
    nodes.put(key, n);
  }

  private void removeTail() {
    if (size == limit + 1) {
      nodes.remove(tail.key);
      tail = tail.prev;
      size--;
    }
  }

  private void setHead(Node n) {
    if (tail.equals(n) && tail.prev != null) {
      tail = tail.prev;
    }

    if (head == null || !head.equals(n)) {
      n.changeDependencies();
      if (head != null) {
        head.prev = n;
      }
      n.next = head;
      head = n;
    }
  }

  public static class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }

    void changeDependencies() {
      if (this.prev != null) {
        this.prev.next = this.next;
      }
      if (this.next != null) {
        this.next.prev = this.prev;
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return key == node.key && val == node.val;
    }

    @Override
    public int hashCode() {
      int result = key;
      result = 31 * result + val;
      return result;
    }
  }

}

