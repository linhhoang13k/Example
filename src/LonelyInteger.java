package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class LonelyInteger {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    int num = 0;
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
      num = num ^ a[a_i];
    }

    System.out.println(num);

  }
}
