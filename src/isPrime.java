package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class IsPrime {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    for (int a0 = 0; a0 < p; a0++) {
      int n = in.nextInt();
      String v = (isPrime(n)) ? "Prime" : "Not prime";
      System.out.println(v);
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    int sqV = (int) Math.sqrt(num);
    for (int i = 2; i <= sqV; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
