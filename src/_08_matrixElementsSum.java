package Arcade_Intro;

public class _08_matrixElementsSum {
    int matrixElementsSum(int[][] matrix) {
        int sum = 0;

        for (int column = 0; column < matrix[0].length; column++)
        {
            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][column] == 0) break;
                sum += matrix[row][column];
            }
        }
        return sum;
    }
}
