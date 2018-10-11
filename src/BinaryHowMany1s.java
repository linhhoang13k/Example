package com.il.training.hackerrank.N30DaysOfCode;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/6/16.
 */
public class BinaryHowMany1s {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int max = 0;
    int currentMax = 0;
    while (n > 0) {
      int r = n % 2;
      n = n / 2;
      if (r == 1) {
        currentMax++;
        if (currentMax > max) {
          max = currentMax;
        }
      } else {
        currentMax = 0;
      }
    }
    System.out.println(max);
  }
}
