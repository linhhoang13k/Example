String[] dashes(int n) {
    String [] r = new String[2*n-1];
    Arrays.fill(r, "");
    for(int i = n; i > 0; i--) {
        for(int j = 1; j < 2*n; j++) {
            String x = j<=n-i||j>=n+i?" ":(n+i+j)%2==0?"|":"-";
            r[i-1] += x;
            r[2*n-i-1] += i==n?"":x;
        }
    }
    return r;
}
