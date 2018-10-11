int leastFactorial(int n) {
    int m = 1;
    int f = 1;
    
    while (n > f) {
        m++;
        f *= m; 
    }
    
    return f;
}
