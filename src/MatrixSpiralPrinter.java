package com.pramp;

/**
 * Created by zambro on 3/5/17.
 */
public class MatrixSpiralPrinter {

    public static void printMatrixSpiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0; //0
        int right = m - 1; //5
        int bottom = n - 1; //0
        int left = 0; //0

        while(top<=bottom && left<=right) { // 0<=
            for(int i = left; i<=right;i++) { //i=1;2<=1;2
                System.out.println(matrix[top][i]); //m[0][0],m[0][1],m[0][2]; //m[1][1]
            }
            top++; //top = 2

            for(int i = top; i<= bottom;i++) { //i=2;2<=1
                System.out.println(matrix[i][right]); //m[1][2],m[2][2]
            }
            right--; //right = 0

            if(top<=bottom)
            for(int i = right; i>=left;i--) { //i=0;0>=1
                System.out.println(matrix[bottom][i]); //m[2][1],m[2][0]
            }
            bottom--; //bottom = 1

            if(left<=right)
            for(int i = bottom; i>=top; i--) { //i=1;1>=1;0
                System.out.println(matrix[i][left]); //m[1][0]
            }
            left++; //left = 1
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, { 4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20}
//        };
//        int[][] matrix = {{1}
//        };
//        int[][] matrix = {{1,2,3,4,5,6}};
        int[][] matrix = {{1},
                {2},
                {3},
                {4}
        };
        printMatrixSpiral(matrix);
    }
}
