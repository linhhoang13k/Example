package com.il.training.topics.graphTheory;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 3/30/17.
 * Disjoint sets
 * https://www.hackerrank.com/challenges/torque-and-development
 */
public class RoadsLibraries {
  public static void main(String[] args) throws Exception {
    Scanner in = JavaTemplate.getFileScanner("graphT/roadsLibraries/tc3.txt");

//		Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      int cities = in.nextInt();
      int roads = in.nextInt();
      int priceLib = in.nextInt();
      int priceRoad = in.nextInt();
      cities++;
      int[] parents = new int[cities];
      for (int i = 0; i < cities; i++) {
        parents[i] = i;
      }
      for (int a1 = 0; a1 < roads; a1++) {
        int city1 = getRoot(parents, in.nextInt());
        int city2 = getRoot(parents, in.nextInt());
        if (city1 != city2) {
          parents[city2] = city1;
        }
      }
      flattenRoot(parents);
      int[] helper = new int[cities]; // filled with 0s
      for (int i = 0; i < cities; i++) {
        helper[parents[i]]++;
      }
      helper[0] = 0; //
      long total = 0;
      for (int i = 0; i < cities; i++) {
        total += getPrice(helper[i], priceLib, priceRoad);
      }

      System.out.println(total);
    }
  }

  private static int getRoot(int[] parents, int val) {
    while (parents[val] != val) {
      val = parents[val];
    }
    return val;
  }

  private static void flattenRoot(int[] parents) {
    for (int i = 0; i < parents.length; i++) {
      parents[i] = getRoot(parents, i);
    }
  }

  private static long getPrice(int nodes, int l, int r) {
    if (nodes == 0) {
      return 0;
    }
    if (nodes == 1) {
      return l;
    }
    if (l <= r) {
      return nodes * l;
    }
    return l + (r * (nodes - 1));
  }

}
