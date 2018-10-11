package com.il.training.hackerrank.sad_examples.oct.three;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesaregb on 10/23/16.
 */
public class Solution6 {

  public static void main(String[] args) {
    Solution6 s6 = new Solution6();

    int[] input = new int[]{2, 3, 12};
    String result = s6.lcmContains(input, 3) ? "YES" : "NO";
    System.out.println(result);
  }

  Boolean[] memo;

  public boolean lcmContains(int[] input, int k) {
    int max = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] > max) {
        max = input[i];
      }
    }
    memo = new Boolean[max + 1];
    List<Integer> primes = getPrimes(max);

    boolean contain = false;
    int i = 0;
    while (!contain && i < input.length) {
      contain = contain || numberFactorization(input[i], primes, k);
      i++;
    }
    return contain;
  }

  public boolean numberFactorization(int n, List<Integer> primes, int search) {
    if (primes.size() == 0) return false;
    if (n == 0) return false;
    if (memo[n] != null) return memo[n];
    List<Integer> primeFactors = new ArrayList<>();
    int primeIndex = 0;

    while (n > 1) {
      int currentPrime = primes.get(primeIndex);

      if (n % currentPrime == 0) {
        if (currentPrime == search) {
          memo[n] = true;
          return true;
        }
        n = n / currentPrime;
        primeFactors.add(currentPrime);
      } else {
        primeIndex++;
      }
    }
    memo[n] = false;
    return false;
  }

  public List<Integer> getPrimes(int n) {
    int[] matrix = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      matrix[i] = i;
    }
    int prime = getNextPrime(matrix, 0, n);
    List<Integer> primes = new ArrayList<>(); // memory management.
    while (prime > 0) {
      primes.add(prime);
      prime = getNextPrime(matrix, prime, n);

    }
    return primes;
  }

  private int getNextPrime(int[] matrix, int index, int n) {
    int prime = 0;
    while (prime == 0 && index < n) prime = matrix[++index];
    if (prime == 0) return prime;
    for (int i = (prime + prime); i <= n; i = (i + prime)) {
      matrix[i] = 0;
    }
    return prime;
  }

//
//	public List<Integer> numberFactorization(int n, List<Integer> primes){
//		if (primes.size() == 0) return null;
//		if (n == 0) return null;
//		List<Integer> primeFactors = new ArrayList<>();
//		int primeIndex = 0;
//
//		while (n > 1){
//			int currentPrime = primes.get(primeIndex);
//
//			if (n % currentPrime == 0){
//				n = n / currentPrime;
//				primeFactors.add(currentPrime);
//			}else{
//				primeIndex++;
//			}
//		}
//		return primeFactors;
//	}


}
