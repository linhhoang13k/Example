package com.il.training.leetcode;

/**
 * Created by cesaregb on 3/20/17.
 * https://leetcode.com/problems/minimum-size-subarray-sum/#/description
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 */
public class MinimumSizeSubarraySum {

  public static void main(String[] args) {
    int[] array = new int[]{1, 1};
    int s = 3;
    System.out.println(minSubArrayLen(s, array));
  }

  // add up elements from left to right, until we get a sum >= s;
  // then we start substracting elements from left to right, to get the most "small" set of elements that are up to that ammount.
  static int minSubArrayLen(int s, int[] array) {
    if (array.length == 0) return 0;
    int start = 0, i = 0, sum = 0, min = Integer.MAX_VALUE;
    boolean result = false;
    while (i < array.length || (sum >= s && start < i)) {
      if (sum >= s) {
        min = Math.min(min, (i - start));
        if (min == 1) return 1;
        sum -= array[start++];
        result = true;
      } else if (i < array.length) {
        sum += array[i];
        i++;
      }
    }
    if (!result) return 0;
    return min;
  }

}
