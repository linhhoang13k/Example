int[][] neighboringCells(int[][] matrix) {
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[i].length;j++){
            int  count = 0;
            if(i > 0) count++;
            if(j > 0) count++;
            if(i < matrix.length-1) count++;
            if(j < matrix[i].length-1) count++;
            matrix[i][j] = count;
        }
    }
    return matrix;
}

/* Given a rectangular matrix consisting of zeroes, replace each zero with the number of neighboring cells for that cell.
Example
matrix = [[0, 0, 0],
          [0, 0, 0],
          [0, 0, 0]]
the output should be
neighboringCells(matrix) = [[2, 3, 2],
                            [3, 4, 3],
                            [2, 3, 2]]
*/
