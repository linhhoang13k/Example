package Array_Strings;


/**
 * Created by Trung on 6/10/2017.
 */
public class Chap1Q7_RotateMatrixTest {

    public static void main(String...args) {

        int[][] matrix = new int[][]{   {0, 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10, 11},
                {12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35}};
        System.out.println("----- Input ------");
        Chap1Q7_RotateMatrix.printMatrix(matrix);

        Chap1Q7_RotateMatrix.rotateMatrix(matrix);

        System.out.println("----- Output ------");
        Chap1Q7_RotateMatrix.printMatrix(matrix);

        matrix = new int[][]{
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}};

        System.out.println("----- Input ------");
        Chap1Q7_RotateMatrix.printMatrix(matrix);

        Chap1Q7_RotateMatrix.rotateMatrix(matrix);

        System.out.println("----- Output ------");
        Chap1Q7_RotateMatrix.printMatrix(matrix);

    }


}