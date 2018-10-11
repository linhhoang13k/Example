package com.il.training.hackerrank.booking1;

import java.util.Scanner;

/**
 * Created by cesaregb on 1/28/17.
 */
public class Polygons {


  public static void main(String[] args) {
    System.out.println(typeOfPolygon("1 1 1 1"));
    System.out.println(typeOfPolygon("1 2 1 2"));
    System.out.println(typeOfPolygon("1 2 1 1"));
  }

  public static void mainA(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = null;
    int[] r = new int[3];
    while (in.hasNextLine() && !((input = in.nextLine()).equals(""))) {
      r[typeOfPolygon(input)]++;
    }
    StringBuilder result = new StringBuilder();
    result.append(r[0]).append(" ").append(r[1]).append(" ").append(r[2]);
    System.out.println(result.toString());

  }

  private static int SQUARE = 0;
  private static int RECTANGLE = 1;
  private static int OTHER = 2;

  static int typeOfPolygon(String input) {
    String[] inputArray = input.split("\\s+");
    int a = Integer.valueOf(inputArray[0]);
    int b = Integer.valueOf(inputArray[1]);
    int c = Integer.valueOf(inputArray[2]);
    int d = Integer.valueOf(inputArray[3]);

    if (a == b && c == d && a == c) return SQUARE;
    if (a == c && b == d) return RECTANGLE;
    return OTHER;
  }
}
