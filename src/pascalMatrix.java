// https://codefights.com/challenge/8nLdnCysfxT2rX64y/solutions/6fuQouC6KbMoAzWAB
int[][] pascalMatrix(int n) {
    int r = (n - 1) / 2 + 1;
    int[][] p = new int[r][n];
    for(int i = 0; i < r; i++) {
        if(i < 1) {
            p[i][r - 1] = 1;
        }
        for(int j = 2; j < r + 1; j++) {
           if(i > 0){
               p[i][r - j] = 1;
               p[i][r + (j - 2)] = 1;
               p[i][r + (j - 4)] = i;
               p[i][(r + 2) - j] = i;
               p[i][r - 1] = p[i - 1][r - 2] + p[i - 1][r - 2];
               if(i > 2) {
                   p[i][r + 1] = p[i - 1][r - 4] + p[i - 1][r - 2];
                   for(int l = 2; l < r; l++) {
                       p[i][r - l] = p[i - 1][r - l + 1] + p[i - 1][r - l - 1];
                      
                   }
                   for(int m = 2; m < r - 1; m++) {
                       if(m % 2 == 0) {
                           p[i][r + m] = p[i][r - (m + 2)];
                       }
                       else {
                           p[i][r + m] = p[i][r - (m + 2)];
                       }
                   }
                   p[i][r] = p[i][r - 2];
               }
               i += 1;
            } 
        }
    }
    return p;
}
