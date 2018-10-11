package com.il.training.facebook;

/**
 * Created by cesaregb on 1/10/17.
 */
public class NumberOfOnes {

  public static void main(String[] args) {
    System.out.println(numSetBits(11));
  }

  public static int numSetBits(long a) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      long mask = (a >> i) & 1;
      result += (mask == 1) ? 1 : 0;
    }
    return result;
  }
}
