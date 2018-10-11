package com.il.training.hackerrank.sad_examples.oct;

/**
 * Created by cesaregb on 10/15/16.
 */
public class Solution10 {

  public static void main(String[] args) {
    int[][] m = new int[3][3];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        m[i][j] = 0;
      }
    }

    m[0][0] = 1;
    m[0][1] = 1;
    m[2][2] = 1;

    int[][] v = new int[3][3];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        v[i][j] = 0;
      }
    }
    int max = 0;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (v[i][j] == 0) {
          max = Math.max(discover(m, i, j, v), max);
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
