package com.il.training.codefights.uber;

/**
 * Created by cesaregb on 12/4/16.
 */
public class Dimensions2 {

  public static void main(String[] args) {
    int[] a = new int[]{3, 2};
    int[][] b = new int[][]{
            {1, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1}
    };
    int[] c = new int[]{0, 3, 3, 3};

    System.out.println(parkingSpot(a, b, c));
  }

  static boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
    boolean fa, fb, fc, fx, fy;
    fa = fb = fc = fx = fy = true;
    int i, j, k, h;
    int a = luckySpot[0];
    int b = luckySpot[1];
    int c = luckySpot[3];
    int d = luckySpot[2];

    for (k = b; k <= d; k++) {
      i = 0;
      j = parkingLot[0].length - 1;
      h = a;

      while ((i < a) || (j > c) || (h <= c)) {
        if (i < a) {
          fa = fa && (parkingLot[k][i] == 0);
        }

        if (j > c) {
          fb = fb && (parkingLot[k][j] == 0);
        }

        if (h <= c) {
          fc = fc && (parkingLot[k][h] == 0);
        }
        i++;
        j--;
        h++;
      }
    }

    for (i = a; i <= c; i++) {
      for (j = 0; j < b; j++) {
        if (parkingLot[j][i] == 1) {
          fx = false;
          break;
        }
      }
      for (j = parkingLot.length - 1; j > d; j--) {
        if (parkingLot[j][i] == 1) {
          fy = false;
          break;
        }
      }
      if (!fx && !fy) {
        break;
      }
    }

    if (fc && ((fx || fy) || (fa || fb))) return true;
    return false;
  }
}
