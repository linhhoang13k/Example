package com.il.training.hackerrank.sad_examples.oct.two;

/**
 * Created by cesaregb on 10/16/16.
 */
public class Solution2 {

  int[] mem;

  public static void main(String[] args) {
    Solution2 s2 = new Solution2();
    int inp = 6;
    s2.mem = new int[inp + 1];
    System.out.println(s2.calculate(inp));
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
