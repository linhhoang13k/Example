package com.il.training.hackerrank.statistics;

import java.util.Arrays;

/**
 * Created by cesaregb on 11/19/16.
 */
public class Statistic1 {

  public static void main2(String[] args) {
    int[] input = new int[]{64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
    Arrays.sort(input);

    System.out.printf("Mean: %.1f; Mode: %.0f, Median: %.1f \n", getMean(input), getMode(input), getMedian(input));

  }


  public static void main(String[] args) {
    Integer a = 1000;
    Integer b = 1000;
    System.out.println(a == b);

    Integer c = 100, d = 100;
    System.out.println(c == d);
  }

  static double getMean(int[] input) {
    int sum = 0;
    for (int i = 0; i < input.length; i++) {
      sum += input[i];
    }
    return (double) sum / input.length;
  }

  static double getMode(int[] sortedInput) {
    if (sortedInput.length == 0) return 0;
    int pop = 1;
    int maxPop = 0;
    int elm = sortedInput[0];
    int result = elm;
    for (int i = 1; i < sortedInput.length; i++) {
      if (sortedInput[i] == elm) {
        pop++;
      } else {
        if (pop > maxPop) {
          maxPop = pop;
          result = elm;
        }
        elm = sortedInput[i];
        pop = 1;
      }
    }
    return result;
  }

  static double getMedian(int[] sortedInput) {
    int midElm = (int) Math.floor(sortedInput.length / 2) - 1;
    if (sortedInput.length % 2 == 0) {
      return (double) (sortedInput[midElm] + sortedInput[midElm + 1]) / 2;
    } else {
      return (double) sortedInput[midElm];
    }
  }


}
