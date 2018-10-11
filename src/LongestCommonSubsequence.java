package com.il.training.topics.dynamicPrograming;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 4/8/17.
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
 */

public class LongestCommonSubsequence {
  public static void main2(String[] args) throws Exception {
    Scanner in = JavaTemplate.getFileScanner("dp/lcs/tc2.txt");
    int n = in.nextInt();
    int m = in.nextInt();
    int[] arrayA = new int[n];
    int[] arrayB = new int[m];
    for (int i = 0; i < n; i++) {
      arrayA[i] = in.nextInt();
    }
    for (int i = 0; i < m; i++) {
      arrayB[i] = in.nextInt();
    }
    recursiveSolution(arrayA, arrayB);
    in.close();
  }

  public static void main(String[] args) throws Exception {
    System.out.println(getLCSLenght("abc", "abc"));
  }

  private static void recursiveSolution(int[] arrayA, int[] arrayB) {
    LongestCommonSubsequence lsc = new LongestCommonSubsequence();
    lsc.memo = new String[arrayB.length][arrayA.length];
    String result = lsc.findLCSRecursive(0, 0, arrayA, arrayB).trim();
    for (int i = 0; i < result.length(); i++) {
      System.out.print(result.charAt(i));
    }
  }

  private String[][] memo;

  private String findLCSRecursive(int indexA, int indexB, int[] arrayA, int[] arrayB) {
    if (indexA >= arrayA.length || indexB >= arrayB.length) {
      return "";
    }
    if (this.memo[indexA][indexB] != null) {
      return this.memo[indexA][indexB];
    }
    int currentDigit = arrayA[indexA++];
    int pos = indexOf(currentDigit, arrayB, indexB);
    StringBuilder sb = new StringBuilder();
    if (pos >= 0) {
      sb.append(String.valueOf(currentDigit)).append(" ").append(findLCSRecursive(indexA, pos + 1, arrayA, arrayB));
    }
    String r2 = findLCSRecursive(indexA, indexB, arrayA, arrayB);
    this.memo[indexA][indexB] = (sb.toString().length() > r2.length()) ? sb.toString() : r2;
    return this.memo[indexA][indexB];
  }

  private static int indexOf(int element, int[] array, int starting) {
    int result = -1;
    for (int i = starting; i < array.length; i++) {
      if (array[i] == element) {
        return i;
      }
    }
    return result;
  }

  // http://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
  private static int getLCSLenght(String a, String b) {
    int dp[][] = new int[a.length() + 1][b.length() + 1];
    // filled with 0s

    for (int i = 1; i <= a.length(); i++) {
      char cA = a.charAt(i - 1);
      for (int j = 1; j <= b.length(); j++) {
        char cB = b.charAt(j - 1);
        if (cA == cB) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[a.length()][b.length()];
  }


}
