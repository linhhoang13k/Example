// https://codefights.com/challenge/KjwiZjbgJ2rHRuWPk/solutions/XxBiEgj5c5ZrsGdfv
int a;
boolean Sudoku(int[][] s) {
    int[] z = new int[9];
    for(int y = 0, w = 0, x = 0; y < 9; y++) {
        for(int i = 0, j = w, k = x; i < 9; i++) {
            z[i] = s[j][k];
            k++;
            if(k % 3 == 0) {
                j++;
                k = x;
            }
        }
        for(int t = 1; t < 10; t++) {
            int m = 0;
            for(int u = 0; u < 9; u++) {
                if(z[u] == t) {
                    m = 1;
                }
            }
            if(m == 0) {
                return false;
            }
        }
        x += 3;
        if(x == 9) {
            w += 3;
            x = 0;
        }
    }
    for(int i = 0; i < 9; i++) {
        for(int j = 1; j < 10; j++) {
            int f = 0;
            int g = 0;
            for(int k = 0; k < 9; k++) {
                if(s[i][k] == j) {
                    f = 1;
                }
                if(s[k][i] == j) {
                    g = 1;
                }
            }
            if(f == 0 || g == 0) {
                return false;
            }
        }
    }
    
    return true;
}
