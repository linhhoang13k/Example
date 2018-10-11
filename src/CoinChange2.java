package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("ALL")
public class CoinChange2 {
  public static void main2(String[] args) {
    CoinChange2 s = new CoinChange2();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int coins[] = new int[m];
    for (int coins_i = 0; coins_i < m; coins_i++) {
      coins[coins_i] = in.nextInt();
    }
    System.out.println(s.makeChange(coins, n));
  }

  public static void main(String[] args) {
    int n = 179;
    int[] coins = new int[]{24, 6, 48, 27, 36, 22, 35, 15, 41, 1, 26, 25, 4, 8, 14, 20, 9, 38, 34, 40, 45, 17, 33, 19, 5, 43, 2};
    System.out.println(makeChange(coins, n));
  }


  private static long makeChange(int[] arr, int n) {
    long[] memo = new long[n + 1];
    memo[0] = 1;
    for (int i = 0; i < arr.length; i++) {
      int coin = arr[i];
      for (int amt = coin; amt <= n; amt++) {
        memo[amt] += memo[amt - coin];
      }
    }
    return memo[n];
  }


}