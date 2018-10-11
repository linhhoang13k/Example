package com.il.training.topics.sorting;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * Created by cesaregb on 6/12/17.
 */
public class SortEvenOdd {

  public static void main(String[] args) {
    int[] r = orderArray(new int[]{1, 2, 3, 4, 5, 6, 7});

    System.out.println(Ints.join(", ", r));
  }

  private static int[] orderArray(int[] input) {
    // O (n log n)
    Arrays.sort(input);

    int[] result = new int[input.length];
    int even = (input.length / 2);
    even += (input.length % 2 > 0) ? 1 : 0;
    int i = 0;
    int index = 0;
    while (even > 0) {
      result[index] = input[i];
      i++;
      even--;
      index += 2;
    }

    index = 1;
    while (i < input.length) {
      result[index] = input[i];
      i++;
      index += 2;
    }

    return result;
  }
}
