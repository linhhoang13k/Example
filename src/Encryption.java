package com.il.training.topics.implmementation;

/**
 * Created by cesaregb on 12/21/16.
 * https://www.hackerrank.com/challenges/encryption
 */
public class Encryption {
    /*
	* input = if man was meant to stay on the ground god would have given us roots
	* LT = ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots
	* L = 54
	* Floor( Sqrt(L)) <= Rows <= column <= Ceil(Sqrt(L))
	* sq = sqrt(54) = 7.34
	* f = Floor(sq) = 7
	* c = Ceil(sq) = 8
	*
	* f = 7
	* c = 8
	*
	*
	* */

  public static void main(String[] args) {
    System.out.println(getEncryptTxt("chillout"));
  }

  private static String getEncryptTxt(String s) {
    int l = s.length();
    double sq = Math.sqrt(l);
    int f = (int) Math.floor(sq);
    int c = (int) Math.ceil(sq);
    System.out.printf("l:%d, sq:%f, f:%d, c:%d", l, sq, f, c);
    System.out.println();

    if ((f * c) < l) {
      f++;
    }

    int charI = 0;
    Character[][] grid = new Character[f][c];
    for (int i = 0; i < f; i++) {
      for (int j = 0; j < c; j++) {
        if (charI < l) {
          grid[i][j] = s.charAt(charI++);
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int j = 0; j < c; j++) {
      for (int i = 0; i < f; i++) {
        if (grid[i][j] != null) {
          result.append(grid[i][j]);
        }
      }
      result.append(" ");
    }

    return result.toString();
  }

}
