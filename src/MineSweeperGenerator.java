package com.ctci.misc.examples;

import java.util.Arrays;

/**
 * Created by zambro on 4/3/17.
 */
public class MineSweeperGenerator {

    public static int[][] minesweeper(boolean[][] matrix) {

        int[][] mines = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++){
                int count = 0;
                count += matrix[i][j] == true?1:0;

                if(i - 1 >= 0)
                    count += matrix[i - 1][j] == true?1:0;

                if(i + 1 < matrix.length)
                    count += matrix[i + 1][j] == true?1:0;

                if(j - 1 >= 0)
                    count += matrix[i][j - 1] == true?1:0;

                if(j + 1 <matrix[0].length)
                    count += matrix[i][j+1] == true?1:0;

                if(i-1>=0 && j-1>=0)
                    count += matrix[i-1][j-1] == true?1:0;

                if(i-1>=0 && j+1<matrix[0].length)
                    count += matrix[i-1][j+1] == true?1:0;

                if(i+1<matrix.length && j-1>=0)
                    count += matrix[i+1][j-1] == true?1:0;

                if(i+1<matrix.length && j+1<matrix[0].length)
                    count += matrix[i+1][j+1] == true?1:0;

                mines[i][j] = count;
            }
        }

        return mines;
    }


    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{{true, false, false},
                {false, true, false},
                {false, false, false}};
        System.out.println(Arrays.deepToString(minesweeper(matrix)));

    }

}
