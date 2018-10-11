package com.il.training.hackerrank.h101Hack47;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 4/19/17.
 */
public class ModularGameNumbers {
  public static void main(String[] args) throws Exception {
    Scanner in = JavaTemplate.getFileScanner("dp/coinChange/tc3.txt");
    int n = in.nextInt();
    int p = in.nextInt();
    int q = in.nextInt();
    int[] array1 = new int[p];
    for (int i = 0; i < p; i++) {
      array1[i] = in.nextInt();
    }

    int[] array2 = new int[q];
    for (int i = 0; i < q; i++) {
      array2[i] = in.nextInt();
    }


  }
}
