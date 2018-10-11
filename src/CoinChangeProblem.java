package com.il.training.topics.dynamicPrograming;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 4/8/17.
 * https://www.hackerrank.com/challenges/coin-change
 */

public class CoinChangeProblem {

  public static void main(String[] args) throws Exception {
    Scanner in = JavaTemplate.getFileScanner("dp/coinChange/tc3.txt");
    int n = in.nextInt();
    int m = in.nextInt();
    int[] coins = new int[m];
    for (int i = 0; i < m; i++) {
      coins[i] = in.nextInt();
    }
    System.out.println(calculateWays(n, coins));
    CoinChangeProblem s = new CoinChangeProblem();
    s.memo = new long[n + 1][n + 1];
    System.out.println(s.calculateWaysRecursive(n, coins, 0));
    in.close();
  }


  private static long calculateWays(int ammount, int[] coins) {
    long[] dp = new long[ammount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int calcAmt = coin; calcAmt <= ammount; calcAmt++) {
        dp[calcAmt] += dp[calcAmt - coin];
      }
    }
    return dp[ammount];
  }

  long memo[][];

  private long calculateWaysRecursive(int amount, int[] coins, int limit) {
    if (amount < 0) {
      return 0;
    }
    if (amount < 1) {
      return 1;
    }
    if (memo[limit][amount] > 0) {
      return memo[limit][amount];
    }
    long result = 0;
    for (int coin : coins) {
      if (coin >= limit) {
        int dif = amount - coin;
        result += calculateWaysRecursive(dif, coins, coin);
      }
    }
    memo[limit][amount] = result;
    return result;

  }
}
