int matrixElementsSum(int[][] arr) {
    int[][] transpose = new int[arr[0].length][arr.length];
	   
    for (int i=0;i<transpose.length;i++) {
        for (int j=0;j<arr.length;j++) {
           transpose[i][j] = arr[j][i];
        }
    }
    
    for (int i=0;i<transpose.length;i++) {
        int k=0;
        while(k < arr.length) {
            if (transpose[i][k] == 0) {
                k++;
                break;
            }
            k++;
        }
        
        while(k < arr.length) {
            transpose[i][k] = 0;
            k++;
        }
    }
    
    int sum = 0;
    for (int i=0;i<transpose.length;i++) {
        for (int j=0;j<arr.length;j++) {
            sum += transpose[i][j];
        }
    }
    
    return sum;
}
