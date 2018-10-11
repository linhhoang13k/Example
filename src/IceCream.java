package com.il.training.hackerrank.ctci;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class IceCream {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int m = in.nextInt();
      int n = in.nextInt();
      int a[] = new int[n];
      HashMap<Integer, Integer> hm = new HashMap<>();
      int i = 1;
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
        int missing = m - a[a_i];
        if (hm.get(missing) != null) {
          System.out.println(hm.get(missing) + " " + i);
        }
        hm.put(a[a_i], i);
        i++;
      }
    }
  }
}
