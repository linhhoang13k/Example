package com.il.training.topics.dynamicPrograming;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 4/9/17.
 * https://www.hackerrank.com/contests/cse-830-homework-3/challenges/edit-distance
 */
public class MinimumEditDistance {

  public static void main(String[] args) throws Exception {
    Scanner in = JavaTemplate.getFileScanner("dp/med/tc1.txt");
    int n = in.nextInt();
    String[] array = new String[2];
    in.nextLine();
    for (int i = 0; i < n; i++) {
      array[0] = in.nextLine();
      array[1] = in.nextLine();

      System.out.println(editDistance(array[0], array[1]));
    }
  }

  private static long editDistance(String a, String b) {
    long dp[][] = new long[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
      dp[i][0] = i;
    }

    for (int i = 0; i <= b.length(); i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= a.length(); i++) {
      char c = a.charAt(i - 1);
      for (int j = 1; j <= b.length(); j++) {
        char d = b.charAt(j - 1);
        if (c == d) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1);
        }
      }
    }

    return dp[a.length()][b.length()];
  }

  private static long min(long a, long b, long c) {
    long r = Math.min(a, b);
    return Math.min(r, c);
  }

}
