package com.il.training.hackerrank.easy;

import java.util.Scanner;

/**
 * Created by cesaregb on 1/30/17.
 */

/*
7 11
5 15
3 2
-2 2 1
5 -6

* */

public class AppleAndOrange {

  public static void main(String[] args) {
    calculateProblem(new int[]{-2, 2, 1}, new int[]{5, -6}, 7, 11, 5, 15);
  }

  public static void mainA(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    in.nextLine();
    int a = in.nextInt();
    int b = in.nextInt();
    in.nextLine();
    int i = in.nextInt();
    int[] m = new int[i];
    int j = in.nextInt();
    int[] n = new int[j];
    in.nextLine();
    for (int c = 0; c < i; c++) {
      m[c] = in.nextInt();
    }
    in.nextLine();
    for (int c = 0; c < j; c++) {
      n[c] = in.nextInt();
    }
    calculateProblem(m, n, s, t, a, b);
  }

  static void calculateProblem(int[] m, int[] n, int s, int t, int a, int b) {
    int[] r = calculateFruit(m, n, s, t, a, b);
    System.out.println(r[0] + " " + r[1]);
  }

  static int[] calculateFruit(int[] m, int[] n, int s, int t, int a, int b) {
    int[] result = new int[2];
    for (int f : m) {
      result[0] += (elementFit(realPos(a, f), s, t)) ? 1 : 0;
    }

    for (int f : n) {
      result[1] += (elementFit(realPos(b, f), s, t)) ? 1 : 0;
    }
    return result;
  }

  static int realPos(int tree, int pos) {
    return tree + pos;
  }

  static boolean elementFit(int pos, int s, int t) {
    return (pos <= t && pos >= s);
  }
}
