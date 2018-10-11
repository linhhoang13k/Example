package com.il.training.topics.recusion;

/**
 * Created by cesaregb on 4/14/17.
 * https://www.careercup.com/question?id=5642960319283200
 * http://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
 */

public class numberOfHops {

  public static void main(String args[]) throws Exception {
    System.out.println(numberOfWays(20));
    System.out.println(numberOfWaysTable(20));
  }

  private static long numberOfWays(int k) {
    if (k < 0) return 0;
    if (k == 0) return 1;
    return numberOfWays(k - 1) + numberOfWays(k - 2) + numberOfWays(k - 3);
  }

  private static long numberOfWaysTable(int k) {
    int[] dp = new int[k + 1];
    dp[0] = 1;
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= 3; j++) {
        int tmp = i - j;
        if (tmp >= 0) {
          dp[i] += dp[tmp];
        }
      }
    }

    return dp[k];
  }


}
