package com.codefights.challenges;

/**
 * Created by zambro on 7/24/17.
 *
 * https://codefights.com/challenge/ZXRv42mfhbiTTDrEB
 *
 * Let's try Minesweeper!
 Each cell of Minesweeper gameboard can be:

 a mine (appears as 9)
 or a number representing the number of mines in its surrounding cells
 (a cell is considered as surrounding another cell when this cell meets that cell on at least 1 corner) (appears as 0 - 8)
 Your task is to check whether a gameboard is a valid gameboard.

 Example
 For

 gameboard = [[0, 1, 9, 1],
 [0, 1, 1, 1],
 [0, 0, 0, 0]]
 the output should be
 minesweeper1(gameboard) = true
 */
public class MineSweeperValidator {

    static boolean minesweeper1(int[][] g) {
        for(int row=0;row<g.length;row++) {
            for(int col=0;col<g[row].length;col++){
                if(g[row][col] != 9){
                    int count = getCount(g[row],col);
                    if(row-1 >= 0)
                        count += getCount(g[row-1], col);
                    if(row+1 < g.length)
                        count += getCount(g[row+1],col);;

                    if(g[row][col] != count)
                        return false;
                }
            }
        }

        return true;
    }

    static int getCount(int[] g, int col) {
        int count = g[col] == 9 ? 1 : 0;
        if(col-1 >=0)
            count += g[col-1] == 9 ? 1 : 0;
        if(col+1 <g.length)
            count += g[col+1] == 9 ? 1 : 0;

        return count;
    }

    public static void main(String[] args) {
        int[][] gameboard = {{0, 1, 9, 1},
                             {0, 1, 1, 1},
                             {0, 0, 0, 0}};
        System.out.println(minesweeper1(gameboard));
    }
}
