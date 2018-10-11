package com.il.training.topics.implmementation;

import java.util.Scanner;

/**
 * Created by cesaregb on 1/7/17.
 */
@SuppressWarnings("Duplicates")
public class AlmostSorted2 {

  public static void main2(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // not used.
    in.nextLine();
    String input = in.nextLine();
    System.out.println(checkList(convertArray(input)));
  }

  public static void main(String[] args) {
    System.out.println(checkList(convertArray("1 2 3")));
    System.out.println();
    System.out.println(checkList(convertArray("4 2")));
    System.out.println();
    System.out.println(checkList(convertArray("3 1 2")));
    System.out.println();
    System.out.println(checkList(convertArray("1 3 2")));
    System.out.println();
    System.out.println(checkList(convertArray("1 5 4 3 2 6")));
    System.out.println();
    System.out.println(checkList(convertArray("43 65 1 98 99 101")));
  }

  private static int[] convertArray(String w) {
    String[] input = w.split(" ");
    int[] r = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      r[i] = Integer.valueOf(input[i]);
    }
    return r;
  }

  private static Result2 checkList(int[] input) {
    Result2 result = new Result2();
    int a = 0;
    while (a < input.length - 1 && input[a] < input[a + 1]) {
      a++;
    }
    if (a + 1 == input.length) {
      result.result = true;
      return result;
    }

    int b = input.length - 1;
    while (b > a && input[b] > input[a]) {
      b--;
    }

    if (a + 1 >= b) { // swap
      result.result = validateBoundaries(input, a, b);
      result.type = 1;
      result.posA = a;
      result.posB = b;
      return result;
    }

    int tmpA = a;
    while (a < b && input[a] > input[a + 1]) {
      a++;
    }
    if (a == b) {
      result.result = validateBoundaries(input, tmpA, b);
      result.type = 2;
      result.posA = tmpA;
      result.posB = b;
      return result;
    }

    return result;
  }

  private static boolean validateBoundaries(int[] arr, int a, int b) {
    return (a == 0 || arr[a - 1] < arr[b]) && (b == (arr.length - 1) || arr[a] < arr[b + 1]);
  }
}

class Result2 {
  boolean result = false;
  int type;
  int posA;
  int posB;

  Result2() {
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
