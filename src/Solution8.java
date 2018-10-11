package com.il.training.hackerrank.sad_examples.oct;

/**
 * Created by cesaregb on 10/13/16.
 */
public class Solution8 {

  public static void main(String[] args) {
    Solution8 s8 = new Solution8();
    long v = (Long.valueOf(1000000000) * 9);
    System.out.println(v);
    System.out.println("-->" + s8.solution(new int[]{1, 10000}));
  }

  public int solution(int[] A) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
    }

    int sum2 = 0;
    for (int i = 0; i < (A.length - 1); i++) {
      sum2 += A[i];
      sum -= A[i];
      int dif = Math.abs(sum2 - sum);
      if (dif < min) {
        min = dif;
      }

    }
    return min;
  }

}
