package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class LeftRotation {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int pointer = k;
    for (int i = 0; i < a.length; i++) {
      if (pointer == a.length) {
        pointer = 0;
      }
      System.out.print(a[pointer] + " ");
      pointer++;
    }
  }

}
