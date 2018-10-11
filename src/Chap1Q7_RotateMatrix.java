package Array_Strings;

import java.util.Arrays;

/**
 * Created by Trung on 6/10/2017.
 *
 * Problem statement: Given an image represented by NxN matrix where each element is 4 bytes, rotate the image 90 degree.
 */
public class Chap1Q7_RotateMatrix {

    public static boolean rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int rows = matrix.length;
        int cols = rows;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[0].length - 1 - i; j++) {
                matrix = rotate(matrix, i, j);
            }
        }
        return true;
    }

    /***
     * Rotate an matrix starting at index (x, y).
     *
     * @param matrix
     * @param x Starting row
     * @param y Starting col
     * @return a matrix where elements of the sub matrix starting at index (x, y) is rotated correctly.
     */
    private static int[][] rotate(int[][] matrix, int x, int y) {
        int[] topLeft = {x, y};
        int[] topRight = {0 + y, matrix.length - 1 - x};
        int[] botLeft = {matrix.length - 1 - x, matrix.length - 1 - y};
        int[] botRight = {matrix.length - 1 - y, x};

        int temp = matrix[topLeft[0]][topLeft[1]];
        matrix[topLeft[0]][topLeft[1]] = matrix[botRight[0]][botRight[1]];
        matrix[botRight[0]][botRight[1]] = matrix[botLeft[0]][botLeft[1]];
        matrix[botLeft[0]][botLeft[1]] = matrix[topRight[0]][topRight[1]];
        matrix[topRight[0]][topRight[1]] = temp;
        return matrix;
    }

    /***
     * Print a matrix.
     *
     * @param ma
     */
    public static void printMatrix(int[][] ma ) {
        StringBuilder sb = new StringBuilder(ma.length);
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[0].length; j++) {
                sb.append(ma[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

}
