package com.il.training.interviewbit.arrays.java;

import java.util.Collections;
import java.util.List;

/**
 * Created by cesaregb on 6/6/17.
 */

// https://www.interviewbit.com/problems/noble-integer/

public class NobleInteger {

  private static int solve(List<Integer> A) {
    Collections.sort(A);
    int size = A.size();
    int i = 0;
    while (i < A.size()) {
      int tmp = A.get(i);
      while (i < A.size() && tmp == A.get(i)) {
        i++;
      }
      if (tmp == (size - i)) {
        return 1;
      }
    }
    return -1;
  }
}
