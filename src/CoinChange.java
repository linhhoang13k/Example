package com.il.training.hackerrank.ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("ALL")
public class CoinChange {
  public static void main(String[] args) {
    CoinChange s = new CoinChange();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    Integer coins[] = new Integer[m];
    for (int coins_i = 0; coins_i < m; coins_i++) {
      coins[coins_i] = in.nextInt();
    }
    s.memo = new long[n + 1][n + 2];
    System.out.println(s.getCombinations(n, n + 1, coins));
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