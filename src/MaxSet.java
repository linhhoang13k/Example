package com.il.training.interviewbit.arrays.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesaregb on 6/6/17.
 */

// https://www.interviewbit.com/problems/max-non-negative-subarray/
public class MaxSet {

  private static void callMaxSete() {
    //		List<Integer> a = Arrays.asList( -1, -1, -1, -1, -1);
//		List<Integer> a = Arrays.asList(1, 2, 5, -7, 2, 3);
//		List<Integer> a = Arrays.asList(  0, 0, -1, 0);
    List<Integer> a = java.util.Arrays.asList(1967513926, 1540383426, -1303455736, -521595368);
    maxset(a).forEach(System.out::println);
  }

  private static ArrayList<Integer> maxset(List<Integer> a) {
    ArrayList<Integer> result = new ArrayList<>();
    int i = 0;
    int fia = -1;
    int fib = -1;
    long max = -1;
    while (i < a.size()) {
      int indexA = -1;
      long sum = 0;
      while (i < a.size() && a.get(i) >= 0) {
        indexA = (indexA < 0) ? i : indexA;
        sum += a.get(i);
        i++;
      }
      if (sum > max) {
        max = sum;
        fia = indexA;
        fib = i - 1;
      } else if (sum == max && (i - 1 - indexA) > (fib - fia) && sum > 0) {
        max = sum;
        fia = indexA;
        fib = i - 1;
      }

      i++;
    }
    if (fia >= 0) {
      for (i = fia; i <= fib; i++) {
        result.add(a.get(i));
      }
    }
    return result;
  }
}
