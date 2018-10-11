int matrixElementsSum(int[][] matrix) {
    int counter = 0;
        for ( int i = 0 ; i < matrix.length ; i++){
        for ( int j = 0 ; j < matrix[0].length ; j++){
                if( i == 0 && matrix[i][j] != 0 ){
                counter += matrix[i][j];
              	}else{
                if( i < matrix.length-1 && matrix[i][j] == 0){
                matrix[i+1][j] = 0;
                }else{
                    counter += matrix[i][j];
                  }
               }
              }
           }
 	return counter;
 
}
