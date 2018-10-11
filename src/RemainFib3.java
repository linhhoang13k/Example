package com.il.training.codefights.marathons;

/**
 * Created by cesaregb on 12/19/16.
 */
@SuppressWarnings("Duplicates")
public class RemainFib3 {

  public static void main(String[] args) {
//		System.out.println(getNumber(5));
    System.out.println(getNumber("8"));
  }

  private static String getNumber(String number) {
    int a = 3;  // initial fib
    long n = Integer.valueOf(number);
    long r = 0;
    while (n > 0) {
      r = fibonacciL(a++) - 1;
      n -= r;
    }
    long tmp = fibonacciL(a) + (r + n);
    return String.valueOf(tmp);
  }

  private static long[] memmoL = new long[1000];

  private static long fibonacciL(int n) {
    if (memmoL[n] > 0) {
      return memmoL[n];
    }
    if (n == 1 || n == 2) {
      memmoL[n] = 1;
    } else {
      memmoL[n] = fibonacciL(n - 1) + fibonacciL(n - 2);
    }
    return memmoL[n];
  }

}
