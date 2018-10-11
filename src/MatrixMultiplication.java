// https://codefights.com/challenge/ZCbCfrifm75LggemN/solutions/it5pMdDvZiEEfBHNs
int[][] MatrixMultiplication(int[][] matrixA, int[][] matrixB) {
    int[][] a = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = matrixA[i][0] * matrixB[0][j] + matrixA[i][1] * matrixB[1][j] + matrixA[i][2] * matrixB[2][j];
				
            }
        }
    return a;
}
