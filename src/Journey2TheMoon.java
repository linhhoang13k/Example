package com.il.training.topics.graphTheory;

import com.il.training.topics.implmementation.GridSearch;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by cesaregb on 1/30/17.
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */

public class Journey2TheMoon {
    /* usage of disjoint sets */

  public static void main(String[] args) throws Exception {
    String fileName = "journey2Moon/input3.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);

    int n = in.nextInt();
    int i = in.nextInt();
    int[][] pairs = new int[i][];
    for (int j = 0; j < i; j++) {
      int[] pair = new int[2];
      pair[0] = in.nextInt();
      pair[1] = in.nextInt();
      pairs[j] = pair;
    }

    long inf = numberOfCombinations(n, pairs);
    System.out.println(inf);

    in.close();
  }

  private static long numberOfCombinations(int nTrainedAst, int[][] pairs) {
    Map<Integer, Integer> nCountries = differentCountries(nTrainedAst, pairs);

    Map<Integer, Integer> totals = new HashMap<>();

    nCountries.entrySet()
            .forEach(e -> {
              totals.putIfAbsent(e.getValue(), 0);
              totals.put(e.getValue(), totals.get(e.getValue()) + 1);
            });

    int[] elements = nCountries.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .mapToInt(Map.Entry::getValue).toArray();

    long result = 0;
    System.out.println("elements.length: " + elements.length);
    for (final int num : elements) {
      totals.put(num, totals.get(num) - 1);
      result += totals.entrySet()
              .stream()
              .filter(e -> e.getKey() <= num)
              .mapToInt(e -> num * (e.getKey() * e.getValue())).sum();
    }
    return result;
  }

  private static Map<Integer, Integer> differentCountries(int n, int[][] pairs) {
    // matrix of number of astronauts
    int[] rootMatrix = new int[n];
    int distinct = 0;
    // initialize each node, and add it to its own graph.
    for (int i = 0; i < n; i++) {
      rootMatrix[i] = i;
      distinct++;
    }

//		nodes on the same pair, belong to the same graph. use the "getRootElement" helper to get to the defined root of the element
    for (int[] pair : pairs) {
      int rA = getRootElement(rootMatrix, pair[0]);
      int rB = getRootElement(rootMatrix, pair[1]);
      if (rA != rB) {
        rootMatrix[rB] = rA;
        distinct--;
      }
    }

    Map<Integer, Integer> sets = new HashMap<>(distinct);
    for (int i = 0; i < n; i++) {
      int index = getRootElement(rootMatrix, rootMatrix[i]);
      sets.putIfAbsent(index, 0);
      sets.put(index, sets.get(index) + 1);
    }

    return sets;
  }

  private static int getRootElement(int[] rootMatrix, int pos) {
    while (rootMatrix[pos] != pos) {
      pos = rootMatrix[rootMatrix[pos]];
    }
    return pos;
  }

}
