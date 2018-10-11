package com.il.training.topics.implmementation;

import java.util.Scanner;

/**
 * Created by cesaregb on 1/7/17.
 * https://www.hackerrank.com/challenges/almost-sorted
 */
@SuppressWarnings("Duplicates")
public class AlmostSorted {

  public static void main2(String[] args) {
    AlmostSorted s = new AlmostSorted();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // not used.
    in.nextLine();
    String input = in.nextLine();
    s.sortArray(convertArray(input));
    System.out.println(s.r);
  }

  Result r = new Result();

  public static void main(String[] args) {
    AlmostSorted s = new AlmostSorted();
//		System.out.println(sortArray(convertArray("1 2 3")));
//		System.out.println();
//		System.out.println(sortArray(convertArray("4 2")));
//		System.out.println();
    s.sortArray(convertArray("3 1 2"));
    System.out.println(s.r);
    System.out.println();
//		System.out.println(sortArray(convertArray("1 3 2")));
//		System.out.println();
//		System.out.println(s.sortArray(convertArray("1 5 4 3 2 6")));
//		System.out.println();
//		System.out.println(s.sortArray(convertArray("1 5 3 4 2 6")));
//		System.out.println();
//		System.out.println(s.sortArray(convertArray("1 9 3 4 5 6 7 8 2 10")));
//		System.out.println();
//		System.out.println(s.sortArray(convertArray("1 9 3 7 5 6 4 8 2 10")));
//		System.out.println();
//		System.out.println(sortArray(convertArray("43 65 1 98 99 101")));
  }

  private static int[] convertArray(String w) {
    String[] input = w.split(" ");
    int[] r = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      r[i] = Integer.valueOf(input[i]);
    }
    return r;
  }

  private boolean sortArray(int[] input) {
    boolean rs = sortArray(input, 0, input.length - 1, false);
    r.result = rs;
    int validateH = Integer.MIN_VALUE;

    for (int i : input) {
      if (i < validateH) {
        r.result = false;
        return false;
      }
      validateH = i;
    }
    return rs;
  }

  private boolean sortArray(int[] input, int startA, int startB, boolean swap) {

    int a = startA;
    while (a < startB - 1 && input[a] < input[a + 1]) {
      a++;
    }
    int b = startB;
    while (b > a && input[b] > input[a]) {
      b--;
    }
    if (a >= b) {
      r.result = true;
      return true;
    }
    if (!validateBoundaries(input, a, b)) {
      return false;
    }
    if (swap && (a > startA || b < startB)) {
      return false;
    }
    // swap
    swap(input, a, b);
    if (r.type == 0) {
      r.type = 1;
      r.posA = a;
      r.posB = b;
    } else if (r.type == 1) {
      r.type = 2;
    }

    return sortArray(input, (a + 1), (b - 1), true);
  }

  private static void swap(int[] input, int a, int b) {
    int tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
  }

  private static boolean validateBoundaries(int[] arr, int a, int b) {
    return (a == 0 || arr[a - 1] < arr[b]) && (b == (arr.length - 1) || arr[a] < arr[b + 1]);
  }
}

class Result {
  boolean result = false;
  int type;
  int posA;
  int posB;

  Result() {
    this.result = false;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    if (result) {
      sb.append("yes");
      if (type > 0) {
        sb.append("\n");
        if (type == 1) {
          sb.append("swap ");
        } else {
          sb.append("reverse ");
        }
        sb.append(posA + 1).append(" ").append(posB + 1);
      }
    } else {
      sb.append("no");
    }
    return sb.toString();
  }
}
