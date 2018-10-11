package com.codefights.challenges;

/**
 * Created by zambro on 7/19/17.
 * https://codefights.com/challenge/dF3Qvny3Yn23xvLRb
 *
 * The Royal Priest of Ur has been kidnapped by the Mad Dragon of Akkad. The gods have chosen you to rescue him! The Dragon has hidden the Priest at the end of a maze, and you must successfully traverse the maze in order to find him. Your task is to determine the minimum number of moves needed to escape the maze, or -1 if it isn't possible to escape.

 The maze is a grid of width w and height h.

 A kindly demigod has given you a list impassable, provided as an array of integers that represent the coordinates of impassable cells. Each integer pair at indices 2 · i and 2 · i + 1 (where  0 ≤ i < impassable.length/2 - 1) represents an impassable cell at coordinate (x, y). For example, the list [1, 2, 3, 4] represents two impassable cells at (1, 2) and (3, 4) (but NOT at (2, 3)).

 You start at cell (0, 0) and escape by reaching the opposite corner at (w - 1, h - 1). It is guaranteed that the start and end cells are not impassable.

 You can only move up, down, left, and right. You can't move diagonally.

 Example
 For w = 4, h = 4 and impassable = [1, 0, 1, 1, 2, 2, 3, 1], the output should be
 MazeEscape(w, h, impassable) = 6.

  - - - -
 |S|#| | |
  - - - -
 | |#| |#|
 - - - - -
 | | |#| |
 - - - - -
 | | | |T|
 - - - - -

 [time limit] 3000ms (java)
 [input] integer w

 The width of the maze.

 Guaranteed constraints:
 2 ≤ w ≤ 150.

 [input] integer h

 The height of the maze.

 Guaranteed constraints:
 2 ≤ h ≤ 150.

 [input] array.integer impassable

 Each integer pair at indices 2 · i and 2 · i + 1 represents an impassable cell at coordinate (x, y).

 Guaranteed constraints:
 0 ≤ impassable.length ≤ w · h - 2 .

 [output] integer

 Return the minimum number of moves needed to escape from the maze and find the Priest, or -1 if it is not possible
 */
public class MazeEscape {
    static int mazeEscape(int w, int h, int[] impassable) {
        boolean[][] visited = new boolean[h][w];
        for(int i=0;i<impassable.length;i = i+2){
            int row = impassable[i+1];
            int col = impassable[i];
            visited[row][col] = true;
        }
//        System.out.println(Arrays.deepToString(visited));
        return findMinPath(visited, 0, 0, h, w);
    }

    //A hidden test is failing
    static int findMinPath(boolean[][] visited, int row, int col, int h, int w) {
        if(row == h-1 && col == w-1)
            return 0;

        visited[row][col] = true;
        int minPath = -1, path;

        //Move down and find the path
        if(row+1<h && !visited[row+1][col]) {
            minPath = findMinPath(visited, row + 1, col, h, w);
        }

        //Move right and find the path
        if(col+1<w && !visited[row][col+1]) {
            path = findMinPath(visited, row, col+1, h, w);
            if(path != -1) {
                if(minPath != -1) {
                    minPath = Math.min(path, minPath);
                } else {
                    minPath = path;
                }
            }
        }

        //Move up and find the path
        if(row-1>=0 && !visited[row-1][col]) {
            path = findMinPath(visited, row -1, col, h, w);
            if(path != -1) {
                if(minPath != -1) {
                    minPath = Math.min(path, minPath);
                } else {
                    minPath = path;
                }
            }

        }

        //Move left and find the path
        if(col-1>=0 && !visited[row][col-1]) {
            path = findMinPath(visited, row, col-1, h, w);
            if(path != -1) {
                if(minPath != -1) {
                    minPath = Math.min(path, minPath);
                } else {
                    minPath = path;
                }
            }
        }

        visited[row][col] = false;
        return minPath != -1? minPath+1:-1;
    }

    public static void main(String[] args) {
        System.out.println(mazeEscape(4,4, new int[]{1, 0, 1, 1, 2, 2, 3, 1}));
        System.out.println(mazeEscape(6,6, new int[]{0,1,2,0,1,2,2,2,3,2,4,2,4,1,4,3,4,4,4,5}));
        System.out.println(mazeEscape(15,4, new int[]{1, 0, 8, 0, 1, 1, 6, 1, 10, 1, 12, 1, 13, 1, 1, 2, 2, 2, 3, 2, 4, 2, 6, 2, 8, 2, 9, 2, 10, 2, 12, 2}));
        System.out.println(mazeEscape(10,10, new int[]{0, 1, 0, 5, 1, 1, 1, 3, 1, 5, 1, 7, 1, 8, 2, 1, 2, 3, 2, 5, 2, 7, 3, 1, 3, 3, 3, 5, 3, 7, 3, 9, 4, 1, 4, 3, 4, 5, 4, 7, 5, 1, 5, 3, 5, 5, 5, 7, 5, 8, 6, 1, 6, 3, 6, 5, 6, 7, 7, 1, 7, 3, 7, 5, 7, 7, 7, 9, 8, 1, 8, 3, 8, 5, 8, 7, 9, 3, 9, 7, 9, 8}));
        System.out.println(mazeEscape(10,10, new int[]{0, 1, 1, 1, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 1, 2, 3, 3, 1, 3, 3, 3, 5, 3, 6, 3, 7, 3, 8, 3, 9, 4, 1, 4, 3, 5, 1, 5, 3, 5, 5, 5, 7, 6, 1, 6, 3, 6, 5, 6, 7, 7, 1, 7, 3, 7, 5, 7, 7, 8, 1, 8, 3, 8, 5, 8, 7, 9, 3, 9, 7}));
        System.out.println(mazeEscape(15,15, new int[]{0, 1, 0, 3, 1, 3, 1, 6, 1, 7, 1, 8, 1, 9, 1, 10, 1, 11, 1, 12, 1, 13, 2, 0, 2, 1, 2, 3, 2, 4, 2, 6, 3, 3, 3, 6, 3, 8, 3, 9, 3, 10, 3, 11, 3, 12, 3, 13, 3, 14, 4, 1, 4, 3, 4, 5, 4, 6, 5, 1, 5, 3, 5, 6, 5, 7, 5, 8, 5, 9, 5, 10, 5, 11, 5, 12, 5, 13, 6, 1, 7, 1, 7, 3, 7, 5, 7, 7, 7, 8, 7, 10, 7, 11, 7, 12, 7, 13, 7, 14, 8, 1, 8, 3, 8, 5, 8, 7, 9, 1, 9, 3, 9, 5, 9, 7, 10, 1, 10, 3, 10, 5, 10, 7, 11, 1, 11, 3, 11, 5, 11, 7, 12, 1, 12, 3, 12, 5, 12, 7, 13, 1, 13, 3, 13, 5, 13, 7, 13, 8, 13, 9, 13, 10, 13, 11, 13, 12, 13, 13, 14, 5}));
    }
}
