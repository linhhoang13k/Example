package com.il.training.topics.dynamicPrograming;

import com.il.training.topics.implmementation.GridSearch;

import java.io.File;
import java.util.Scanner;

/**
 * Created by cesaregb on 2/1/17.
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 */
@SuppressWarnings("Duplicates")
public class SherlockAndCost {

  public static void main(String[] args) throws Exception {
    String fileName = "sherlockAndCost/tc1.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);
    SherlockAndCost sol = new SherlockAndCost();

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

  private static long solution(int[] b) {
    int[] options = new int[b.length];
    for (int i = 0; i < b.length; i++) {
      options[i] = Math.abs(1 - b[i]);
    }

    for (int option : options) {
      System.out.println("\t" + option);
    }

    long res = 0;
    for (int i = 0; i < options.length; i += 2) {
      long helper = (i < options.length - 1) ? options[i + 1] : 0;
      helper *= (i < options.length - 2) ? 2 : 1;
      long max = Math.max(options[i], helper);
      System.out.println(max + " " + i);
      res += max;

    }

    return res;
  }

}
