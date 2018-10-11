package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
public class BubbleSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int l = in.nextInt();
    int[] arr = new int[l];
    for (int i = 0; i < l; i++) {
      int v = in.nextInt();
      arr[i] = v;
    }
    int nSwaps = 0;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = tmp;
          nSwaps++;
        }
      }
    }
    System.out.println("Array is sorted in " + nSwaps + " swaps.");
    System.out.println("First Element: " + arr[0]);
    System.out.println("Last Element: " + arr[arr.length - 1]);

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
  }
}
