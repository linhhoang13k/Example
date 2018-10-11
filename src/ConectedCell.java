package com.il.training.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("Duplicates")
public class ConectedCell {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }


    int[][] v = new int[n][m];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        v[i][j] = 0;
      }
    }
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (v[i][j] == 0) {
          max = Math.max(discover(grid, i, j, v), max);
        }
      }
    }
    System.out.println(max);
  }

  public static int discover(int[][] m, int y, int x, int[][] v) {
    int result = 0;

    if ((y < 0 || y >= m.length) || (x < 0 || x >= m[0].length)) {
      return result;
    }

    if (v[y][x] == 1) {
      return result;
    }

    v[y][x] = 1;
    result += m[y][x];
    if (result == 1) {
      result += discover(m, y + 1, x + 1, v);
      result += discover(m, y + 1, x, v);
      result += discover(m, y, x + 1, v);
      result += discover(m, y - 1, x - 1, v);
      result += discover(m, y - 1, x, v);
      result += discover(m, y, x - 1, v);
      result += discover(m, y - 1, x + 1, v);
      result += discover(m, y + 1, x - 1, v);
    }


    return result;
  }
}
