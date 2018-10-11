package com.ctci.misc.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zambro on 3/21/17.
 */
public class PrintMatrixColumnFirst {

    public static void print(int[][] matrix) {

        for(int i=0;i<matrix[i].length;i++)
            for(int j=0;j<matrix.length;j++)
                System.out.println(matrix[j][i]);
    }


    public static int matrixElementsSum(int[][] matrix) {
        int sum = 0;

        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++) {
                if(matrix[j][i] == 0) {
                    break;
                }
                sum += matrix[j][i];
            }

        return sum;
    }


    public static void main(String[] args) {
//        PrintMatrixColumnFirst.print(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}});
        System.out.println(PrintMatrixColumnFirst.matrixElementsSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        List<String> list = new ArrayList<>();
        String[] s = list.toArray(new String[list.size()]);
    }
}
