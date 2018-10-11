package com.il.training.topics.dynamicPrograming;

import com.il.training.topics.implmementation.GridSearch;

import java.io.File;
import java.util.Scanner;

/**
 * Created by cesaregb on 2/1/17.
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 */
@SuppressWarnings("Duplicates")
public class SherlockAndCost3 {

  public static void main(String[] args) throws Exception {
    String fileName = "sherlockAndCost/tc1.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);
    SherlockAndCost3 sol = new SherlockAndCost3();

    int n = in.nextInt();
    for (int j = 0; j < n; j++) {
      int bLenght = in.nextInt();
      int[] b = new int[bLenght];
      for (int i = 0; i < bLenght; i++) {
        b[i] = in.nextInt();
      }
      System.out.println(sol.solution(b));
    }
  }

  // TODO review and study....
  static long solution(int[] b) {
    int[][] dp = new int[b.length][2];
    for (int i = 1; i < b.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + Math.abs(b[i - 1] - 1));
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + Math.abs(b[i] - 1));
    }
    long result = Math.max(dp[b.length - 1][0], dp[b.length - 1][1]);
    return result;
  }

}
