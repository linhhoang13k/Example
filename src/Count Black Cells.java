nt gcd(int n, int m){
    while (m>0) {
        int temp = n;
        n = m;
        m = temp%m;
    }
     
    return n;
}

int countBlackCells(int n, int m) {
    if (n == m) return (n + 2*(n-1));
    if (n == 1 || m==1 ) return n*m;
    return n + m -gcd(n, m) + (gcd(n, m)-1)*2;
}
