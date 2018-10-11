package com.il.training.topics.implmementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by cesaregb on 1/28/17.
 * https://www.hackerrank.com/challenges/bomber-man
 */
public class Bomberman {

  public static void main_(String[] args) {
    String[] grid = new String[]{
            ".......",
            "...O...",
            "....O..",
            ".......",
            "OO.....",
            "OO....."
    };
    char[][] result = calculateState(parseGrid(grid));
    printGrid(result);
  }

  public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
    String fileName = "bomberman/tc3.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);

    int r = in.nextInt();
    int c = in.nextInt();
    int n = in.nextInt();
    in.nextLine();
    String[] grid = new String[r];
    String input;
    int i = 0;
    while (in.hasNextLine() && !((input = in.nextLine()).equals(""))) {
      grid[i++] = input;
    }
    prepareCall(grid, r, c, n);
  }

  private static void prepareCall(String[] grid, int r, int c, int n) {
    char[][] charGrid = parseGrid(grid);
    if (n == 1) {
      printGrid(charGrid);
      return;
    } else if (n % 2 == 0) {
      printGrid(fullGrid(r, c));
      return;
    } else if (n % 4 == 1) {
      charGrid = calculateState(parseGrid(grid)); // g2
      charGrid = calculateState(charGrid);
      printGrid(charGrid);
      return;
    } else {
      charGrid = calculateState(parseGrid(grid));
    }
    printGrid(charGrid);
  }

  private static char[][] calculateState(char[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    char[][] charArr = new char[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        charArr[i][j] = 'O';
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == 'O') {
          createExplosion(charArr, i, j, '.');
        }

      }
    }
    return charArr;
  }

  private static void createExplosion(char[][] grid, int i, int j, char c) {
    grid[i][j] = c;
    if (i - 1 >= 0) {
      grid[i - 1][j] = c;
    }
    if (i + 1 < grid.length) {
      grid[i + 1][j] = c;
    }
    if (j - 1 >= 0) {
      grid[i][j - 1] = c;
    }
    if (j + 1 < grid[0].length) {
      grid[i][j + 1] = c;
    }

  }

  private static char[][] parseGrid(String[] grid) {
    char[][] charArr = new char[grid.length][grid[0].length()];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length(); j++) {
        charArr[i][j] = grid[i].charAt(j);
      }
    }
    return charArr;
  }

  private static void printGrid(char[][] grid) {
    for (char[] ca : grid) {
      for (char c : ca) {
        System.out.print(c);
      }
      System.out.println();
    }
  }

  private static char[][] fullGrid(int r, int c) {
    char[][] charGrid = new char[r][c];
    char[] part = new char[c];
    for (int i = 0; i < c; i++) {
      part[i] = 'O';
    }
    for (int i = 0; i < r; i++) {
      charGrid[i] = part;
    }
    return charGrid;
  }

  static char[][] reverseGrid(char[][] grid) {
    char[][] charArr = new char[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        char a = (grid[i][j] == '.') ? 'O' : '.';
        charArr[i][j] = a;
      }
    }
    return charArr;
  }

}
