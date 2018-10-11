package com.ctci.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zambro on 3/6/17.
 */
public class ZeroMatrixGenerator {

    public static void zeroMatrix(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();

        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[i].length;j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                    break;
                }
            }
        }

        //Set rows to zero
        Iterator rowIterator = rowSet.iterator();
        while(rowIterator.hasNext()) {
            int row = (int) rowIterator.next();
            for(int j = 0;j<matrix[row].length;j++)
                matrix[row][j] = 0;
        }


        //Set cols to zero
        Iterator colIterator = colSet.iterator();
        while(colIterator.hasNext()) {
            int col = (int) colIterator.next();
            for(int i = 0;i<matrix.length;i++)
                matrix[i][col] = 0;
        }
    }

    public static void makeRowColumnZero(int[][] matrix) {

        boolean isFirstRowZero = false, isFirstColumnZero = false;
        for(int i=0;i<matrix[0].length;i++)
            if(matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }

        for(int i=0;i<matrix.length;i++)
            if(matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }

        for(int i=1;i<matrix.length;i++) {
            for(int j=1;j<matrix[i].length;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i< matrix.length; i++) {
            if(matrix[i][0] == 0) {
                ///set the ith row as zero
                for(int j = 1; j<matrix[i].length; j++)
                    matrix[i][j] = 0;
            }
        }

        for(int i=1; i<matrix[0].length; i++){
            if(matrix[0][i] == 0) {
                //set the jth column as zero
                for(int j=1; j<matrix.length;j++)
                    matrix[j][i] = 0;
            }
        }

        if(isFirstRowZero)
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i] = 0;

        if(isFirstColumnZero)
            for(int i=0;i<matrix.length;i++)
                matrix[i][0] = 0;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,2,1,1},
                {0,2,3,1,1},
                {1,1,1,0,1},
                {1,1,0,1,1}
        };
        makeRowColumnZero(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
