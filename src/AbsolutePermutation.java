package com.il.training.topics.implmementation;

/**
 * Created by cesaregb on 1/28/17..
 * https://www.hackerrank.com/challenges/absolute-permutation
 */

public class AbsolutePermutation {

  public static void main(String[] args) {
    System.out.println(prepareCall(100, 2));
  }

  static String prepareCall(int n, int k) {
    StringBuilder result = new StringBuilder("-1");
    // create helper grid
    int[] grid = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      grid[i] = i;
    }
    GridResult gridResult = new GridResult(n + 1);
    calculatePos(grid, gridResult, 1, k);
    if (gridResult.valid) {
      result = new StringBuilder();
      for (int i = 1; i < gridResult.result.length; i++) {
        result.append(gridResult.result[i]).append(" ");
      }
    }
    return result.toString().trim();
  }

  private static void calculatePos(int[] grid, GridResult r, int index, int k) {
    if (index == grid.length) {
      return;
    }
    int a = index - k;
    int b = index + k;

    if (a > 0 && grid[a] > 0) {
      r.result[index] = a;
      grid[a] = -1;
      calculatePos(grid, r, index + 1, k);
      if (r.valid) return;
      grid[a] = a;
    }
    if (a > 0 && grid[a] > 0) {
      r.valid = false;
      return;
    }
    if (b < grid.length && grid[b] > 0) {
      r.result[index] = b;
      grid[b] = -1;
      calculatePos(grid, r, index + 1, k);
      if (r.valid) return;
      grid[b] = b;
    }
    r.valid = false;
  }

  public static class GridResult {
    int[] result;
    boolean valid;

    GridResult(int size) {
      this.result = new int[size];
      this.valid = true;
    }
  }

}
