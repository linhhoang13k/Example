package com.il.training.interviewbit.math;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 5/15/17.
 */
public class Math {

  public static void main(String[] args) {
//		System.out.println(getDifference(7, 2));
//		List<Integer> l = Arrays.asList(2, 4, 6);
//		System.out.println(hammingDistance2(l));

//		Integer arr[] = {1, 2, 7, 0, 9, 3, 6, 8, 5, 4};
    Integer arr[] = {1, 0, 3, 2};
    List lst = Arrays.asList(arr);

    arrange(lst);
    System.out.print("[");
    lst.forEach(a -> System.out.print(a + ", "));
    System.out.println("]");

  }

  static int getDifference(int a, int b) {
    int cnt = 0;
    int v = a ^ b;
    while (v > 0) {
      cnt += v & 1;
      v = v >> 1;

    }
    return cnt;
  }

  static int hammingDistance(final List<Integer> A) {
    int result = 0;
    for (int i = 0; i < A.size(); i++) {
      for (int j = i + 1; j < A.size(); j++) {
        result += ((getDifference(A.get(i), A.get(j)) * 2) % 1000000007);
      }
    }
    return result;
  }

  static int hammingDistance2(final List<Integer> A) {
    int result = 0;
    int[] a = new int[32];
    int[] b = new int[32];
    for (int i = 0; i < A.size(); i++) {
      int v = A.get(i);
      for (int j = 0; j < 32; j++) {
        a[j] += v & 1;
        b[j] += ((v & 1) == 1) ? 0 : 1;
        v = v >> 1;
      }
    }
    for (int i = 0; i < 32; i++) {
      result += (2 * a[i] * b[i]);
    }
    return result;
  }

  public static void arrange(List<Integer> a) {
    int n = a.size();
    for (int i = 0; i < a.size(); i++) {
      int val = a.get(i) + ((a.get(a.get(i)) % n) * n);
      a.set(i, val);
    }

    for (int i = 0; i < a.size(); i++) {
      int val = a.get(i) / n;
      a.set(i, val);
    }
  }


  public static void arrange2(List<Integer> a) {
    int[] flag = new int[a.size()];
    for (int i = 0; i < a.size(); i++) {
      arrangeByIndex(a, i, flag);
    }
  }

  static int arrangeByIndex(List<Integer> a, int i, int[] c) {
    if (c[i] == 1) {
      return a.get(i);
    }
    int r = a.get(i);
    c[i] = 1;
    a.set(i, arrangeByIndex(a, r, c));
    return r;
  }
}
