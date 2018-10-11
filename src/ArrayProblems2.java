package com.il.training.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 5/30/17.
 */
public class ArrayProblems2 {

  String val = "{algo: \"algo\"}";


  public static void main(String[] args) {
    ArrayProblems2 ap2 = new ArrayProblems2();
//		callHotel(ap2);
//		callLargestNumber(ap2);
//		callMaxGap(ap2);
//		callSubUnsort();

  }

  public static int maximumGap(final List<Integer> A) {
    if (A == null || A.size() < 2)
      return 0;

    int max = A.get(0);
    int min = A.get(0);
    int n = A.size();

    for (int i = 0; i < n; i++) {
      max = Math.max(max, A.get(i));
      min = Math.min(min, A.get(i));
    }

    int buckets = n - 1;
    int gap = (max - min - 1) / (n - 1) + 1;
    int minArray[] = new int[buckets];
    int maxArray[] = new int[buckets];
    int bucket;

    Arrays.fill(minArray, Integer.MAX_VALUE);
    Arrays.fill(maxArray, Integer.MIN_VALUE);

    for (int i = 0; i < n; i++) {
      int num = A.get(i);

      if (num == max || num == min)
        continue;

      bucket = (num - min) / gap;

      minArray[bucket] = Math.min(minArray[bucket], num);
      maxArray[bucket] = Math.max(maxArray[bucket], num);
    }

    int res = 0;
    int maxVal = max;

    for (int i = 0; i < buckets; i++) {
      max = minArray[i];

      if (max != Integer.MAX_VALUE)
        res = Math.max(res, max - min);

      if (maxArray[i] != Integer.MIN_VALUE) {
        min = maxArray[i];
      }
    }

    res = Math.max(res, maxVal - min);

    return res;
  }


  private static void callSubUnsort() {
    // 1, 2
    subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))).forEach(System.out::println);

    // 4, 10
    subUnsort(new ArrayList<>(Arrays.asList(1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15))).forEach(System.out::println);
  }

  public static ArrayList subUnsort(List<Integer> inputList) {
    int i = 0;
    int j = inputList.size() - 1;
    while (i < j && inputList.get(i) <= inputList.get(i + 1)) {
      i++;
    }
    while (i < j && inputList.get(j) >= inputList.get(j - 1)) {
      j--;
    }
    if (i == j) {
      return new ArrayList<>(Arrays.asList(-1));
    }

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int k = i; k <= j; k++) {
      min = Math.min(min, inputList.get(k));
      max = Math.max(max, inputList.get(k));
    }
    i = 0;
    while (i < inputList.size() - 1 && inputList.get(i) <= min) {
      i++;
    }

    j = inputList.size() - 1;
    while (j > 0 && inputList.get(j) >= max) {
      j--;
    }

    return new ArrayList<>(Arrays.asList(i, j));

  }


}
