package com.il.training.hackerrank.sad_examples.oct.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by cesaregb on 10/16/16.
 */
@SuppressWarnings("Duplicates")
public class Solution3A {
  public static void main(String[] args) {
    Solution3A s3 = new Solution3A();

    int n = 10;
    Integer[] arr = new Integer[]{2, 5, 3, 6}; // -- 10
//		Integer[] arr = new Integer[]{5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43, 49, 46, 19, 41, 1, 12, 11, 28}; // -- 96190959
//		Integer[] arr = new Integer[]{25, 10, 11, 29, 49, 31, 33, 39, 12, 36, 40, 22, 21, 16, 37, 8, 18, 4, 27, 17, 26, 32, 6, 38, 2, 30, 34};  // -- 16694
//		Integer[] arr = new Integer[]{1,2,3}; // -- 4
    s3.memo = new int[n + 1];

//		arr = s3.getCoins(arr);
    System.out.println(s3.getCombinations(n, arr));
  }

  int[] memo;

  private Integer[] getCoins(int element, Integer[] arr, boolean lower) {
    if (arr.length == 0) return null;
    HashSet<Integer> tD = new HashSet<>(); // avoid duplicates
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      boolean add;
      if (lower) {
        add = (element > arr[i] && !tD.contains(arr[i]));
      } else {
        add = (element >= arr[i] && !tD.contains(arr[i]));
      }

      if (add) {
        tD.add(arr[i]);
        resultList.add(arr[i]);
      }
    }

    resultList.sort((o1, o2) -> o1 - o2);

    return resultList.toArray(new Integer[0]);
  }


  private int getCombinations(int n, Integer[] arr) {
    if (arr == null || arr.length == 0) return 0;
    if (memo[n] > 0) {
      return memo[n];
    }

    int result = 0;
    arr = getCoins(n, arr, false);

    for (int i = 0; i < arr.length; i++) {
      int coin = arr[i];
      if ((n % coin) == 0) {
        result++;
      }
      int times = n / coin;
      for (int j = 1; j <= times; j++) {
        int diff = n - (coin * j);
        if (diff > 0) {
//					int substract = (diff % coin == 0)?1:0;
          result += getCombinations(diff, getCoins(coin, arr, false));
        }

      }
    }

//		memo[n] = result;
    return result;
  }


  public static long makeChange(int[] coins, int money) {
    long[] DP = new long[money + 1]; // O(N) space.
    DP[0] = (long) 1;    // n == 0 case.
    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];
      for (int j = coin; j < DP.length; j++) {
        // The only tricky step.
        DP[j] += (j - coin >= 0 ? DP[j - coin] : 0);
      }
    }
    return DP[money];
  }

}
