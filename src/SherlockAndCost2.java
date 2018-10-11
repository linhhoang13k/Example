package com.il.training.topics.dynamicPrograming;

import com.il.training.topics.implmementation.GridSearch;

import java.io.File;
import java.util.Scanner;

/**
 * Created by cesaregb on 2/1/17.
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 */
@SuppressWarnings("Duplicates")
public class SherlockAndCost2 {

  public static void main(String[] args) throws Exception {
    String fileName = "sherlockAndCost/tc1.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);

    int n = in.nextInt();
    for (int j = 0; j < n; j++) {
      int bLenght = in.nextInt();
      int[] b = new int[bLenght];
      for (int i = 0; i < bLenght; i++) {
        b[i] = in.nextInt();
      }
      System.out.println(solution(b));
    }
  }

  static long solution(int[] b) {
    int[][] options = new int[b.length - 1][2];
    for (int i = 0; i < b.length - 1; i++) {
      options[i] = getDifferences(b[i], b[i + 1]);
    }
    return Math.max(calculateTotal(0, 0, options, 1), calculateTotal(0, 0, options, 2));
  }

  static int[] getDifferences(int a, int b) {
    int[] r = new int[2];
    r[0] = Math.abs(1 - a);
    r[1] = Math.abs(1 - b);
    return r;
  }

  static long calculateTotal(long sum, int index, int[][] options, int pos) {
    if (index == options.length) return sum;
    long a = sum + ((pos == 2) ? options[index][0] : 0);
    long b = sum + ((pos == 1) ? options[index][1] : 0);
    long r = Math.max(calculateTotal(a, index + 1, options, 1),
            calculateTotal(b, index + 1, options, 2));
    return r;
  }

}
