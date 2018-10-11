package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class Fibonacci {

  int[] memmo = null;

  public int fibonacci(int n) {
    if (memmo[n] == 0) {
      if (n == 1 || n == 2) {
        memmo[n] = 1;
      } else {
        int fib = fibonacci(n - 1) + fibonacci(n - 2);
        memmo[n] = fib;
      }
    }
    return memmo[n];
  }

  public static void main(String[] args) {
    Fibonacci s = new Fibonacci();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    s.memmo = new int[n + 1]; // primitive type makes it 0s
    scanner.close();
    System.out.println(s.fibonacci(n));
  }
}
