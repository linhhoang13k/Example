package com.il.training.codefights.marathons;

import java.math.BigInteger;

/**
 * Created by cesaregb on 12/19/16.
 */
@SuppressWarnings("Duplicates")
public class RemainFib {

  public static void main(String[] args) {
//		System.out.println(getNumber(5));
    System.out.println(getNumber("8"));
  }

  private static String getNumber(String number) {
    int a = 3;
    BigInteger n = new BigInteger(number);
    BigInteger r = new BigInteger("0");
    while (n.compareTo(new BigInteger("0")) > 0) {
      r = fibonacciL(a++).subtract(new BigInteger("1"));
      n = n.subtract(r);
    }
    BigInteger tmp = fibonacciL(a).add(r.add(n));
    return String.valueOf(tmp);
  }

  private static BigInteger[] memmoL = new BigInteger[10000];

  private static BigInteger fibonacciL(int n) {

    if (memmoL[n] != null && memmoL[n].compareTo(new BigInteger("0")) > 0) {
      return memmoL[n];
    }
    if (n == 1 || n == 2) {
      memmoL[n] = new BigInteger("1");
    } else {
      memmoL[n] = fibonacciL(n - 1).add(fibonacciL(n - 2));
    }
    return memmoL[n];
  }
}
