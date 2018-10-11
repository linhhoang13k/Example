package com.il.training.topics.implmementation;

import java.math.BigInteger;

/**
 * Created by cesaregb on 12/18/16.
 * https://www.hackerrank.com/challenges/extra-long-factorials
 */
public class ExtraLongFactorials {

  public static void main(String[] args) {
    System.out.println(extraLongFactorial(25).toString());
  }

  /**
   * 5! = 5 * 4 * 3 * 2 * 1 =
   *
   * @param n
   * @return
   */
  public static BigInteger extraLongFactorial(int n) {
    BigInteger bi = new BigInteger(String.valueOf(n));
    if (n == 1) {
      return BigInteger.ONE;
    }
    return bi.multiply(extraLongFactorial(n - 1));
  }


}
