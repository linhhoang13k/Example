package com.il.training.topics.implmementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/28/16.
 * https://www.hackerrank.com/challenges/the-grid-search
 */

public class GridSearch {

  public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
    String fileName = "gridSearchInput/gridSearchInput3.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int R = in.nextInt();
      int C = in.nextInt();
      String G[] = new String[R];
      for (int G_i = 0; G_i < R; G_i++) {
        G[G_i] = in.next();
      }
      int r = in.nextInt();
      int c = in.nextInt();
      String P[] = new String[r];
      for (int P_i = 0; P_i < r; P_i++) {
        P[P_i] = in.next();
      }
      if (findPattern(G, P)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static boolean findPattern(String[] grid, String[] pattern) {
    for (int i = 0; i < grid.length; i++) {
      String gridFirstLine = grid[i];
      boolean foundOrExit = false;
      int tmpHolder = 0;
      int index = 0;
      while (!foundOrExit && index < gridFirstLine.length()) {
        RabinKarp rk = new RabinKarp(pattern[0]);
        tmpHolder = index;
        index = rk.findString(gridFirstLine.substring(index, gridFirstLine.length()));
        if (index >= 0) {
          index = index + tmpHolder;
          System.out.println("i: " + i + " index: " + index);
          foundOrExit = true;
          for (int j = 1; j < pattern.length; j++) {
            RabinKarp child = new RabinKarp(pattern[j]);
            if ((i + j) < grid.length
                    && (index + pattern[0].length()) <= grid[0].length()) {
              String subString = grid[i + j].substring(index, (index + pattern[0].length()));
              int r = child.findString(subString);
              System.out.println(index + " == r: " + r + "\nP:" + child.pat + "\nS:" + subString + "\n");
              foundOrExit = foundOrExit && (r >= 0);
            } else {
              j = pattern.length;
              foundOrExit = false;
            }
          }
          if (foundOrExit) {
            return true;
          }
          index++;
        } else {
          foundOrExit = true;
        }
      }
    }
    return false;
  }
}


class RabinKarp {
  private long patHash;
  String pat;
  private int len;
  private long prime;


  RabinKarp(String input) {
    this.prime = longRandomPrime();
    this.pat = input;
    this.len = input.length();
    hashString();
  }

  private void hashString() {
    for (int i = 0; i < this.pat.length(); i++) {
      int vC = (int) this.pat.charAt(i);
      this.patHash += vC * (Math.pow(this.prime, i));
    }
  }

  // Rabin–Karp implementation.
  int findString(String search) {
    int fIndex = -1;
    if (search.length() < this.len) {
      return fIndex;
    }
    long sHash = 0;

    for (int i = 0; i < this.len; i++) {
      int vC = (int) search.charAt(i);
      sHash += vC * (Math.pow(this.prime, i));
    }

    int i = this.len;
    boolean found = false;
    while (i <= search.length() && !found) {
      if (sHash == this.patHash && compareStrings(this.pat, search.substring(i - this.len, i))) {
        found = true;
        fIndex = i - this.len;
      }
      if (i < search.length()) {
        sHash = (sHash - (int) search.charAt(i - this.len)) / this.prime;
        int vC = (int) search.charAt(i);
        sHash += vC * (Math.pow(this.prime, (this.len - 1)));
      }
      i++;
    }
    return fIndex;
  }

  private boolean compareStrings(String a, String b) {
//		System.out.println(a + " == " + b + " " + i);
    return a.equals(b);
  }

  // a random 31-bit prime
  private static long longRandomPrime() {
//		BigInteger prime = BigInteger.probablePrime(31, new Random());
//		return prime.longValue();
    return 3;
  }

}

