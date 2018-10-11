package com.il.scribd;

/**
 * Created by cesaregb on 12/12/16.
 */
public class One {

  // get te better (bigger in number) value
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
            {1, 5, 3, 2},
            {2, 3, 6, 1},
            {10, 4, 4, 1}
    };

    System.out.println(getBestPath(0, matrix, 0, 0));
  }

  public static int getBestPath(int val, int[][] matrix, int column, int row) {
    if (column >= matrix.length || row >= matrix[0].length) {
      return 0;
    }
    val += matrix[column][row];
    if ((column + 1) == matrix.length && (row + 1) == matrix[0].length) {
      return val;
    }
    return Math.max(getBestPath(val, matrix, column + 1, row),
            getBestPath(val, matrix, column, row + 1));

  }

}
