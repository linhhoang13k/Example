package com.il.training.hackerrank.sad_examples.oct.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by cesaregb on 10/16/16.
 */
public class Solution3 {
  public static void main(String[] args) {
    Solution3 s3 = new Solution3();

    int n = 250;
//		Integer[] arr = new Integer[]{1, 2}; // -- 6 -- 4
//		Integer[] arr = new Integer[]{2, 5, 3, 6}; // -- 10 -- 5
//		Integer[] arr = new Integer[]{5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43, 49, 46, 19, 41, 1, 12, 11, 28}; // 166 -- 96190959
//		Integer[] arr = new Integer[]{25, 10, 11, 29, 49, 31, 33, 39, 12, 36, 40, 22, 21, 16, 37, 8, 18, 4, 27, 17, 26, 32, 6, 38, 2, 30, 34};  // 75 -- 16694
    Integer[] arr = new Integer[]{41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11};  // 250 -- 15,685,693,751
//		Integer[] arr = new Integer[]{1,2,3}; // -- 4 -- ?
    s3.memo = new long[n + 1][n + 2];

    System.out.println(s3.getCombinations(n, (n + 1), arr));
  }

  long[][] memo;

  private Integer[] getCoins(Integer[] arr, int n, boolean lower) {
    if (arr.length == 0) return null;
    HashSet<Integer> tD = new HashSet<>(); // avoid duplicates
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int coin = arr[i];
      boolean add = !tD.contains(coin)
              && ((lower && coin < n) || (!lower && coin <= n));

      if (add) {
        tD.add(coin);
        resultList.add(coin);
      }
    }
    resultList.sort((o1, o2) -> o1 - o2);
    return resultList.toArray(new Integer[0]);
  }


  private long getCombinations(int n, int requester, Integer[] arr) {

    if (memo[n][requester] > 0) return memo[n][requester];

    if (n < requester) {
      // si contaremos las monedas de misma denominacion que n.
      arr = getCoins(arr, n, false);
    } else {
      // si NO contaremos las monedas de la misma denominacion que n
      // get elements lower then (coin) requester ...
      arr = getCoins(arr, requester, true);
    }

    if (arr == null || arr.length == 0) return 0;

    long result = 0;

    for (int i = arr.length - 1; i >= 0; i--) {
      int coin = arr[i];
      if (n % coin == 0) {
        // si coin es igual a lo que andamos buscando...
        result++;
      }

      int times = n / coin;

      for (int j = 1; j <= times; j++) {
        int dif = n - (coin * j);
        if (dif > 0) {
          result += getCombinations(dif, coin, arr);
        }
      }
    }

    if (n < requester) {
      memo[n][requester] = result;
    } else {
      memo[n][requester] = result;
    }

    return result;
  }

}
