/*
Implement an algorithm to multiply two matrices.

Example

For

matrix1 = [[1, 1, 1],
           [0, 0, 0]]
and

matrix2 = [[2, 1],
           [1, 2],
           [2, 1]]
the output should be

matrixMultiplication(matrix1, matrix2) = [[5, 4],
                                          [0, 0]]
*/

int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
}