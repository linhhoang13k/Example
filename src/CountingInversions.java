package com.il.training.hackerrank.ctci;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("Duplicates")
public class CountingInversions {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    NumberFormat formatter = new DecimalFormat("#0");
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int arr[] = new int[n];
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
      }
      System.out.println(formatter.format(getSwaps(arr, 0, arr.length - 1)));
    }
  }

  private static double getSwaps(int[] arr, int index1, int index2) {
    if (arr.length < 2) {
      return 0;
    }
    if (index1 >= index2) {
      return 0;
    }
    double r = 0;
    int mid = (index1 + index2) / 2;
    r = r + getSwaps(arr, index1, mid);
    r = r + getSwaps(arr, (mid + 1), index2);
    return r + (merge(arr, index1, mid, (mid + 1), index2));
  }

  private static double merge(int[] arr, int a, int b, int c, int d) {
    double swaps = 0;
    int[] helper = new int[(d - a) + 1];

    for (int i = 0; i < helper.length; i++) {
      helper[i] = arr[(a + i)];
    }

    int left = a;
    int right = c;
    int index = a;
    while (left <= b && right <= d) {
      if (helper[(left - a)] <= helper[(right - a)]) {
        arr[index] = helper[(left - a)];
        left++;
      } else {
        arr[index] = helper[(right - a)];
        swaps = swaps + ((b + 1) - left);
        right++;
      }
      index++;
    }
    while (left <= b) {
      arr[index] = helper[(left - a)];
      left++;
      index++;
    }
    while (right <= d) {
      arr[index] = helper[(right - a)];
      right++;
      index++;
    }

    return swaps;
  }

}
