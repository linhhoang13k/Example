package com.il.training.interviewbit.arrays.java;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 6/9/17.
 */
public class SetMatrixZeros {

  public static void main(String[] args) {
    List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1, 0, 1),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1, 1, 1));

    setZeroes(matrix);

    matrix.forEach(m -> {
              m.forEach(System.out::print);
              System.out.println();
            }
    );
  }

  public static void setZeroes(List<List<Integer>> matrix) {
    int[] flagsA = new int[matrix.size()];
    int[] flagsB = new int[matrix.get(0).size()];

    for (int i = 0; i < matrix.size(); i++) {
      for (int j = 0; j < matrix.get(0).size(); j++) {
        if (matrix.get(i).get(j) == 0) {
          flagsA[i] = 1;
          flagsB[j] = 1;
        }
      }
    }

    for (int i = 0; i < matrix.size(); i++) {
      if (flagsA[i] == 1) {
        for (int j = 0; j < matrix.get(0).size(); j++) {
          matrix.get(i).set(j, 0);
        }
      }
    }

    for (int i = 0; i < matrix.get(0).size(); i++) {
      if (flagsB[i] == 1) {
        for (int j = 0; j < matrix.size(); j++) {
          matrix.get(j).set(i, 0);
        }
      }
    }

  }
}
