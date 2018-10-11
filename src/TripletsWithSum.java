package com.il.training.interviewbit.arrays.java;

import java.util.ArrayList;

/**
 * Created by cesaregb on 6/6/17.
 */

//https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
@SuppressWarnings("Duplicates")
public class TripletsWithSum {

  private static double TWO_THIRDS = 2.0 / 3.0;
  private static Range rangeA = new Range(0, false, TWO_THIRDS, false);
  private static Range rangeB = new Range(TWO_THIRDS, true, 1, true);
  private static Range rangeC = new Range(1, false, 2, false);

  public static int check(double[] list) {
    double[] triplet = findTriplet(list);
    if (triplet == null) {
      return 0;
    } else {
      return 1;
    }
  }

  public static double[] findTriplet(double[] list) {
    int n = list.length;
    if (n < 3) {
      return null;
    }
    double[] case1 = caseOne(list);
    if (case1 != null) {
      return case1;
    }
    double[] case2 = caseTwo(list);
    if (case2 != null) {
      return case2;
    }
    double[] case3 = caseThree(list);
    if (case3 != null) {
      return case3;
    }
    double[] case4 = caseFour(list);
    if (case4 != null) {
      return case4;
    }
    double[] case5 = caseFive(list);
    if (case5 != null) {
      return case5;
    }
    return null;
  }

  private static double[] caseOne(double[] list) {
    double[] maximumA = getMaxesInRange(list, 3, rangeA);
    if (maximumA == null) {
      return null;
    }
    double sum = maximumA[0] + maximumA[1] + maximumA[2];
    boolean inRange = numInRange(sum, rangeC);
    if (!inRange) {
      return null;
    }
    return new double[]{maximumA[0], maximumA[1], maximumA[2]};
  }

  private static double[] caseTwo(double[] list) {
    double[] maximumA = getMaxesInRange(list, 2, rangeA);
    if (maximumA == null) {
      return null;
    }
    double sum = maximumA[0] + maximumA[1];
    int n = list.length;
    for (int i = 0; i < n; i++) {
      boolean inRange = numInRange(list[i], rangeB);
      if (inRange && list[i] > 1 - sum && list[i] < 2 - sum) {
        return new double[]{maximumA[0], maximumA[1], list[i]};
      }
    }
    return null;
  }

  private static double[] caseThree(double[] list) {
    double[] minimumA = getMinsInRange(list, 2, rangeA);
    if (minimumA == null) {
      return null;
    }
    double[] minimumC = getMinsInRange(list, 1, rangeC);
    if (minimumC == null) {
      return null;
    }
    double sum = minimumA[0] + minimumA[1] + minimumC[0];
    boolean inRange = numInRange(sum, rangeC);
    if (!inRange) {
      return null;
    }
    return new double[]{minimumA[0], minimumA[1], minimumC[0]};
  }

  private static double[] caseFour(double[] list) {
    double[] minimumB = getMinsInRange(list, 2, rangeB);
    if (minimumB == null) {
      return null;
    }
    double sum = minimumB[0] + minimumB[1];
    int n = list.length;
    for (int i = 0; i < n; i++) {
      boolean inRange = numInRange(list[i], rangeA);
      if (inRange && list[i] < 2 - sum) {
        return new double[]{minimumB[0], minimumB[1], list[i]};
      }
    }
    return null;
  }

  private static double[] caseFive(double[] list) {
    double[] minimumA = getMinsInRange(list, 1, rangeA);
    if (minimumA == null) {
      return null;
    }
    double[] minimumB = getMinsInRange(list, 1, rangeB);
    if (minimumB == null) {
      return null;
    }
    double[] minimumC = getMinsInRange(list, 1, rangeC);
    if (minimumC == null) {
      return null;
    }
    double sum = minimumA[0] + minimumB[0] + minimumC[0];
    boolean inRange = numInRange(sum, rangeC);
    if (!inRange) {
      return null;
    }
    return new double[]{minimumA[0], minimumB[0], minimumC[0]};
  }

  private static double[] getMinsInRange(double[] list, int numMins, Range range) {
    int n = list.length;
    double[] mins = new double[numMins];
    double[] minIndices = new double[numMins];
    for (int i = 0; i < numMins; i++) {
      mins[i] = -1;
      minIndices[i] = -1;
      for (int j = 0; j < n; j++) {
        boolean inRange = numInRange(list[j], range);
        if ((list[j] <= mins[i] || minIndices[i] == -1) && inRange) {
          boolean good = true;
          for (int k = 0; k < i; k++) {
            if (j == minIndices[k]) {
              good = false;
              break;
            }
          }
          if (good) {
            mins[i] = list[j];
            minIndices[i] = j;
          }
        }
      }
      if (minIndices[i] == -1) {
        return null;
      }
    }
    return mins;
  }

  private static double[] getMaxesInRange(double[] list, int numMaxes, Range range) {
    int n = list.length;
    double[] maxes = new double[numMaxes];
    double[] maxIndices = new double[numMaxes];
    for (int i = 0; i < numMaxes; i++) {
      maxes[i] = -1;
      maxIndices[i] = -1;
      for (int j = 0; j < n; j++) {
        boolean inRange = numInRange(list[j], range);
        if ((list[j] >= maxes[i] || maxIndices[i] == -1) && inRange) {
          boolean good = true;
          for (int k = 0; k < i; k++) {
            if (j == maxIndices[k]) {
              good = false;
              break;
            }
          }
          if (good) {
            maxes[i] = list[j];
            maxIndices[i] = j;
          }
        }
      }
      if (maxIndices[i] == -1) {
        return null;
      }
    }
    return maxes;
  }

  private static boolean numInRange(double num, Range range) {
    boolean inRange = true;
    if (range.lowerInclusive) {
      inRange &= (num >= range.lowerBound);
    } else {
      inRange &= (num > range.lowerBound);
    }
    if (range.upperInclusive) {
      inRange &= (num <= range.upperBound);
    } else {
      inRange &= (num < range.upperBound);
    }
    return inRange;
  }

  private static class Range {
    public double lowerBound;
    public boolean lowerInclusive;
    public double upperBound;
    public boolean upperInclusive;

    public Range(double lowerBound, boolean lowerInclusive, double upperBound, boolean upperInclusive) {
      this.lowerBound = lowerBound;
      this.lowerInclusive = lowerInclusive;
      this.upperBound = upperBound;
      this.upperInclusive = upperInclusive;
    }
  }


  public int solve(ArrayList<String> A) {
    double b[] = new double[A.size()];
    int i = 0;
    for (String x : A) {
      b[i++] = Double.parseDouble(x);
    }
    return TripletsWithSum.check(b);

  }
}
