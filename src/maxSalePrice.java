int maxSalePrice(int w, int[] m) {
    int i, j, n = m.length, a[][] = new int[n + 1][w + 1];
    for(i = 0; i < n; i++) {
        for(j = 1; j <= w; j++) 
            a[i + 1][j] = i > j?a[i][j]:Math.max(a[i][j], a[i][j - i] + m[i]);
    }
    return a[n][w];
}
    //recursive solution, hits TLE
    //return m.length == 0 || w == 0?0:m.length - 1 > w?maxSalePrice(w, Arrays.copyOfRange(m, 0, Math.max(0, m.length - 1))):Math.max(maxSalePrice(w, Arrays.copyOfRange(m, 0, Math.max(0, m.length - 1))), m[m.length - 1] + maxSalePrice(w - m.length + 1, Arrays.copyOfRange(m, 0, Math.max(0, m.length - 1))));
