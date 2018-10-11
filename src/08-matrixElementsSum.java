int matrixElementsSum(int[][] matrix) {
    int sum = 0;
    for(int i =0; i<matrix[0].length;i++){
        for(int j =0; j<matrix.length; j++){
            if(matrix[j][i] != 0){
                sum += matrix[j][i];
            }else{
                break;
            }
        }
    }
    return sum;
}