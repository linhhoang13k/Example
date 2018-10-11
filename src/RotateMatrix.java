package com.il.training.interviewbit.arrays.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 6/10/17.
 */

//https://www.interviewbit.com/problems/rotate-matrix/
public class RotateMatrix {

  public static void main(String[] args) {

    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(Arrays.asList(1, 2));
    matrix.add(Arrays.asList(3, 4));
    printMatrix(matrix);
    rotate(matrix);
    System.out.println("***************");
    printMatrix(matrix);

    System.out.println("***************");
    matrix = new ArrayList<>();
    matrix.add(Arrays.asList(1, 2, 3));
    matrix.add(Arrays.asList(4, 5, 6));
    matrix.add(Arrays.asList(7, 8, 9));
    printMatrix(matrix);
    rotate(matrix);
    System.out.println("***************");
    printMatrix(matrix);

    System.out.println("***************");
    matrix = new ArrayList<>();
    matrix.add(Arrays.asList(31, 32, 228, 333));
    matrix.add(Arrays.asList(79, 197, 241, 246));
    matrix.add(Arrays.asList(77, 84, 126, 337));
    matrix.add(Arrays.asList(110, 291, 356, 371));
    printMatrix(matrix);
    rotate(matrix);
    System.out.println("***************");
    printMatrix(matrix);
  }

  public static void rotate(List<List<Integer>> inputMatrix) {
    int len1 = inputMatrix.size() - 1;
    int len2 = inputMatrix.get(0).size() - 1;
    for (int i = 0; i <= len1 / 2; i++) {
      for (int j = i; j < (len2 - i); j++) {

        int topLeft = inputMatrix.get(i).get(j);

        // button-left -> top-left
        int buttonLeft = inputMatrix.get(len1 - j).get(i);
        inputMatrix.get(i).set(j, buttonLeft);

        // button right -> button-left
        int buttonRight = inputMatrix.get(len1 - i).get(len2 - j);
        inputMatrix.get(len1 - j).set(i, buttonRight);

        // top right -> button right
        int topRight = inputMatrix.get(j).get(len2 - i);
        inputMatrix.get(len1 - i).set(len2 - j, topRight);

        // top-left -> topRight
        inputMatrix.get(j).set(len2 - i, topLeft);

      }
    }

  }

  private static void printMatrix(List<List<Integer>> inputMatrix) {
    for (List<Integer> l : inputMatrix) {
      for (Integer i : l) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
