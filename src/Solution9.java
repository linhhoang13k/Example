package com.il.training.hackerrank.sad_examples.oct.three;

/**
 * Created by cesaregb on 10/25/16.
 */
public class Solution9 {
  public static void main(String[] args) {
    System.out.println(findBalancedSubsequence("()())"));
    System.out.println(findBalancedSubsequence("))))((("));
    System.out.println(findBalancedSubsequence("()(((((()"));
  }


  public static int findBalancedSubsequence(String input) {
    if (input.length() < 2) return 0;
    int complete = 0;
    int open = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(') {
        open++;
      } else {
        if (open > 0) {
          open--;
          complete++;
        }
      }
    }
    return complete * 2;
  }

  public int findLongestBalancedSubsequence(String seq, int n) {
    int[][] lengths = new int[n][n];

    for (int l = 1; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        // Ends are balanced.
        if (seq.charAt(i) == '(' && seq.charAt(j) == ')') {
          // lengths[i, j] = max(lengths[i + 1, j - 1] + 2, lengths[i + 1, j] +
          // lengths[i, j - 1] - lengths[i + 1, j - 1])
          if (lengths[i + 1][j - 1] + 2 > lengths[i + 1][j] +
                  lengths[i][j - 1] - lengths[i + 1][j - 1])
            lengths[i][j] = lengths[i + 1][j - 1] + 2;
          else
            lengths[i][j] = lengths[i + 1][j] +
                    lengths[i][j - 1] - lengths[i + 1][j - 1];
          // Ends are not balanced.
        } else {
          // lengths[i, j] = max(lengths[i + 1, j], lengths[i, j - 1])
          if (lengths[i + 1][j] > lengths[i][j - 1])
            lengths[i][j] = lengths[i + 1][j];
          else
            lengths[i][j] = lengths[i][j - 1];
        }
      }
    }

    return lengths[0][n - 1];
  }
}
