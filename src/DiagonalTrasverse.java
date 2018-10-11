package com.il.training.topics.grids;

/**
 * Created by cesaregb on 4/14/17.
 * https://www.careercup.com/question?id=5163286157852672
 */
public class DiagonalTrasverse {
  public static void main(String args[]) throws Exception {
    int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
    };


    getMatrixOutput(matrix);
  }


  private static void getMatrixOutput(int[][] matrix) {
    int a = matrix.length;
    int b = 0;
    int lenA = matrix.length;
    int lenB = matrix[0].length;
    while (a > 0 || b < lenB) {
      int i = a--;
      int j = b;
      if (a < 0) {
        a = 0;
        b++;
      }
      while (i < lenA && j < lenB) {
        System.out.print(matrix[i][j] + " ");
        i++;
        j++;
      }
      System.out.println();
    }


  }
}
