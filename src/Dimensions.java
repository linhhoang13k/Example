package com.il.training.codefights.uber;

/**
 * Created by cesaregb on 12/4/16.
 */
@SuppressWarnings("Duplicates")
public class Dimensions {

  public static void main(String[] args) {
//		int[] a = new int[]{3, 2};
//		int[][] b = new int[][]{
//			{1,0,1,0,1,0},
//			{0,0,0,0,1,0},
//			{0,0,0,0,0,1},
//			{1,0,1,1,1,1}
//		};
//		int[] c = new int[] {1, 1, 2, 3};
    int[] a = new int[]{3, 2};
    int[][] b = new int[][]{
            {1, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1}
    };
    int[] c = new int[]{1, 1, 2, 3};

    System.out.println(parkingSpot(a, b, c));
  }

  static boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
    int direction = 2;
    if (carDimensions[0] > carDimensions[1]) {
      direction = 1;
    }

    int a = luckySpot[0];
    int b = luckySpot[1];
    int c = luckySpot[2];
    int d = luckySpot[3];

    boolean top, right, button, left;
    top = right = button = left = true;
    if (!validateSpot(parkingLot, a, b, c, d)) {
      return false;
    }

    if (direction == 1) {
      for (int i = b; i <= c; i++) {
        for (int j = 0; j < a; j++) {
          left = left && (parkingLot[i][j] == 0);
        }
        for (int j = parkingLot[0].length - 1; j > d; j--) {
          right = right && (parkingLot[i][j] == 0);
        }
      }
      if (left || right) {
        return true;
      }
    } else {
      for (int i = a; i <= d; i++) {
        for (int j = 0; j < b; j++) {
          top = top && (parkingLot[j][i] == 0);
        }
        for (int j = parkingLot.length - 1; j > c; j--) {
          button = button && (parkingLot[j][i] == 0);
        }
      }
      if (top || button) {
        return true;
      }
    }

    return false;
  }

  static boolean validateSpot(int[][] parkingLot, int a, int b, int c, int d) {
    for (int i = a; i <= c; i++) {
      for (int j = b; j <= d; j++) {
        if (parkingLot[i][j] == 1) {
          return false;
        }
      }
    }
    return true;
  }
}
