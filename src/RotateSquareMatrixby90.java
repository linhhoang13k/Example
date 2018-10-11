package com.ctci.chapter1;

/**
 * Created by zambro on 3/2/17.
 */
public class RotateSquareMatrixby90 {


    public static int[][] rotateMatrixBy90(int[][] matrix) {
        int n = matrix.length;
        //Lets start from top layer

        for(int layer = 0; layer<n/2; layer++ ) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i=first;i<last;i++) {
                //Move right element to temp;
                int temp = matrix[i][last];

                //Move top to right
                matrix[i][last] = matrix[first][i];

                //Move left to top
                matrix[first][i] = matrix[last-i+first][first];

                //Move bottom to left
                matrix[last-i+first][first] = matrix[last][last-i+first];

                //Move temp to bottom
                matrix[last][last-i+first] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1, 2, 3, 4},{5,6, 7,8},{9,0,11,12},{13,14,15,16}};
        matrix = rotateMatrixBy90(matrix);
        for(int[] row:matrix) {
            for(int i:row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
