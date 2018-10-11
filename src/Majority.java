package com.il.training.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cesaregb on 1/10/17.
 */
public class Majority {

  public static void main(String[] args) {
    System.out.println(majorityElement(Arrays.asList(2, 1, 2)));
  }

  public static int majorityElement(final List<Integer> a) {
    double limit = Math.floor(a.size() / 2);
    HashMap<Integer, Integer> helper = new HashMap<>();
    for (Integer i : a) {
      helper.putIfAbsent(i, 0);
      helper.put(i, helper.get(i) + 1);
      if (helper.get(i) > limit) {
        return i;
      }
    }
    return 0;
  }
}
