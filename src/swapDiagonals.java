int[][] swapDiagonals(int[][] matrix) {
    int len = matrix.length;
   for (int i = 0; i < len; ++i){
                int temp = matrix[i][i];
                matrix[i][i] = matrix[i][len-i-1];
                matrix[i][len-i-1] = temp;
   }
    return matrix;
}

matrix = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
the output should be

swapDiagonals(matrix) = [[3, 2, 1],
                         [4, 5, 6],
                         [9, 8, 7]]
