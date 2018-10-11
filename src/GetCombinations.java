package com.il.training.topics.recusion;

/**
 * Created by cesaregb on 10/22/16.
 */
public class GetCombinations {

  public static void main(String[] args) {
    System.out.println(getCombinations("", 3, 0));
  }

  private static String getCombinations(String init, int n, int starting) {
    if (n == 0) return init;
    StringBuilder result2 = new StringBuilder();
    for (int i = starting; i <= 9; i++) {
      result2.append(getCombinations(i + init, (n - 1), i));
    }

    return result2.toString();
  }


}
