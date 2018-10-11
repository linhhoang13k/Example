package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("Duplicates")
public class Staricase {

  int[] mem;

  public static void main(String[] args) {
    Staricase sol = new Staricase();
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    for (int a0 = 0; a0 < s; a0++) {
      int n = in.nextInt();
      sol.mem = new int[n + 1];
      System.out.println(sol.calculate(n));
    }
  }

  public int calculate(int n) {
    if (n == 1) {
      return 1;
    }
    if (mem[n] > 0) {
      return mem[n];
    }
    int holder = 0;

    if (n == 2) {
      holder = 1 + calculate(n - 1);
    } else if (n == 3) {
      holder = 1 + calculate(n - 1) + calculate(n - 2);
    } else {
      holder = calculate(n - 1) + calculate(n - 2) + calculate(n - 3);
    }
    mem[n] = holder;
    return mem[n];
  }
}
