package com.il.training.hackerrank.ctci;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cesaregb on 12/2/16.
 */
public class TwoStacks {

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}

class MyQueue<T> {
  Stack<T> read = new Stack<>();
  Stack<T> write = new Stack<>();

  public void enqueue(T element) {
    write.add(element);
  }

  public T dequeue() {
    write2Read();
    return read.pop();
  }

  private void write2Read() {
    if (read.size() == 0) {
      // get write into read
      while (!write.isEmpty()) {
        read.add(write.pop());
      }
    }
  }

  public T peek() {
    write2Read();
    return read.peek();
  }
}