package com.il.training.topics.grids;

/**
 * Created by cesaregb on 1/29/17.
 */

// Solution making usage of  Union-Find
// based on
//      http://www.programcreek.com/2014/04/leetcode-number-of-islands-java/
//      https://discuss.leetcode.com/topic/11590/simple-java-solution/2
public class NumOfIslands {

  public static void main(String[] args) {
//		int[][] grid = new int[][]{
//				{1, 1, 0, 0, 0},
//				{0, 1, 0, 0, 1},
//				{1, 0, 0, 1, 1},
//				{0, 0, 0, 0, 0},
//				{1, 0, 1, 0, 1},
//		};
//		System.out.println(numOfIslands(grid, 5, 5));
//
//		String[] g1 = new String[]{
//				"1 1 0 0 0",
//				"0 1 0 0 1",
//				"1 0 0 1 1",
//				"0 0 0 0 0",
//				"1 0 1 0 1"
//		};
//		System.out.println(numOfIslands(parseGrid(g1), 5, 5));
//
//		String[] g2 = new String[]{
//				"1 0 1"
//		};
//		System.out.println(numOfIslands(parseGrid(g2), 1, 3));

    String[] g3 = new String[]{
            "1 0 0 0 0",
            "1 1 1 1 1",
            "0 1 0 1 0",
            "1 0 0 0 1"
    };
    System.out.println(numOfIslands(parseGrid(g3), 4, 5));


  }

  static int[][] parseGrid(String[] g1) {
    int[][] grid = new int[g1.length][g1[0].length()];
    for (int i = 0; i < g1.length; i++) {
      // clean input string.... "," used only on local dev...
      String tmp = g1[i].replaceAll("\\s+", "");
      for (int j = 0; j < tmp.length(); j++) {
        int a = tmp.charAt(j) - '0';
        grid[i][j] = a;
      }
    }
    return grid;
  }


  // these are mapped accordingly for accessing the surrending positions.
  // possible moves on the x
  static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
  // possible moves on the y
  static int[] dy = new int[]{0, 0, 1, -1, -1, 1, 1, -1};

  static int numOfIslands(int[][] grid, int rows, int cols) {
    int nElements = 0;

    // create and "pre-fill" a matrix array.
    // matrix to keep track of current "parent" of the joint set
    int[] rootMatrix = new int[rows * cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          // element made of:
          //      (x * num_cols) + y
          // to put as neighbors in a single array, similar to min-heap.
          int index = (i * cols) + j;
          rootMatrix[index] = index;
          //number of possible different islands
          nElements++;
        }

      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // if element is part of an island, check neighbors with the helper position matrix.
        if (grid[i][j] == 1) {
          for (int k = 0; k < dx.length; k++) {
            // arithmetic op, using helpers.
            int x = i + dx[k];
            int y = j + dy[k];

            // check if generated position is valid..
            if ((x >= 0 && y >= 0 && x < rows && y < cols) && grid[x][y] == 1) {
              int currentRoot = getElementRoot(rootMatrix, (i * cols) + j);
              int neighborNodeRoot = getElementRoot(rootMatrix, (x * cols) + y);
              if (currentRoot != neighborNodeRoot) {
                rootMatrix[neighborNodeRoot] = currentRoot;
                // adjacent islands, we decrement the number of possible different
                nElements--;
              }
            }
          }
        }
      }
    }

    return nElements;
  }


  static int getElementRoot(int[] rootMatrix, int pos) {
    while (rootMatrix[pos] != pos) {
      pos = rootMatrix[rootMatrix[pos]];
    }
    return pos;
  }

}
