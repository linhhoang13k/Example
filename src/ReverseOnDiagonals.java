int[][] reverseOnDiagonals(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
        int j = n - i - 1;
        int tmp = matrix[i][i];
        matrix[i][i] = matrix[j][j];
        matrix[j][j] = tmp;
        tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
    return matrix;
}

The longest diagonals of a square matrix are defined as follows:

the first longest diagonal goes from the top left corner to the bottom right one;
the second longest diagonal goes from the top right corner to the bottom left one.
Given a square matrix, your task is to reverse the order of elements on both of its longest diagonals.

Example

For

matrix = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
the output should be

reverseOnDiagonals(matrix) = [[9, 2, 7],
                              [4, 5, 6],
                              [3, 8, 1]]
