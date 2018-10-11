int[] rowsToCols(int[] r) {
    int c = r.length, b, i, j, a [] = new int[c];
    for(i = c; i > 0; i--) {
        b = 1;
        for(j = c - 1; j >= 0; j--) {
            a[i-1]+=r[j]%2*b;
            r[j]/=2;
            b*=2;
        }
    }
    return a;
}
