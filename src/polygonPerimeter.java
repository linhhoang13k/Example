int polygonPerimeter(boolean[][] matrix) {
    int res = 0;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
            if(matrix[i][j]) {
                if(i == 0 || i == matrix.length - 1)
                    res++;
                if(i > 0 && !matrix[i - 1][j])
                    res++;
                if(i < matrix.length - 1 && !matrix[i + 1][j])
                    res++;
                if(j == 0 || j == matrix[i].length - 1)
                    res++;
                if(j > 0 && !matrix[i][j - 1])
                    res++;
                if(j < matrix.length - 1 && !matrix[i][j + 1])
                    res++;
            }
        }
    }
    return res;
}
