package com.il.training.hackerrank.sad_examples.oct.two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesaregb on 10/17/16.
 */
public class Solution4 {

  public static void main(String[] args) {
    Solution4 s4 = new Solution4();
    s4.getCharCombinations("abc").forEach(it -> {
      System.out.println(it);
    });
  }

  private List<String> getCharCombinations(String input) {
    if (input.length() == 0) return null;
    List<String> result = new ArrayList<>();

    char c = input.charAt(0);
    result.add(String.valueOf(c));
    List<String> childs = getCharCombinations(input.substring(1, input.length()));
    if (childs != null) {
      childs.forEach(it -> {
        result.add(String.valueOf(c) + it);
      });
      result.addAll(childs);
    }

    return result;
  }

  private List<String> getCharCombinations2(String input) {

    return null;
  }
}
