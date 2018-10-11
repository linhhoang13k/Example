package com.il.training.interviewbit.arrays.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by cesaregb on 6/6/17.
 */
//https://www.interviewbit.com/problems/wave-array/

public class WaveArray {
  private static void callWave() {
    ArrayList<Integer> p = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    String listString = wave(p).stream().map(Object::toString).collect(Collectors.joining(", "));
    System.out.println(listString);
  }

  /**
   * [1, 2, 3, 4] => [2, 1, 4, 3]
   * https://www.interviewbit.com/problems/wave-array/
   *
   * @param a
   * @return
   */
  public static ArrayList<Integer> wave(ArrayList<Integer> a) {
    Collections.sort(a);
    ArrayList<Integer> result = new ArrayList<>();
    int i = 0;
    while (i < a.size() - 1) {
      result.add(a.get(i + 1));
      result.add(a.get(i));
      i += 2;
    }
    if (a.size() % 2 > 0) {
      result.add(a.get(a.size() - 1));
    }

    return result;
  }

  public static ArrayList<Integer> wave2(ArrayList<Integer> a) {
    Collections.sort(a);
    ArrayList<Integer> result = new ArrayList<>();
    int mid = (a.size() / 2);
    mid += (a.size() % 2 == 0) ? 0 : 1;
    for (int i = 0; i < a.size() / 2; i++) {
      result.add(a.get(i));
      result.add(a.get(mid + i));
    }
    if (a.size() % 2 > 0) {
      result.add(a.get(mid - 1));
    }

    return result;
  }
}
