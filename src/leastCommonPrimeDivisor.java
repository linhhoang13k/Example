int leastCommonPrimeDivisor(int a, int b) {
    int m = Math.min(a, b);
    int sum = 0;
    for (int i = 2; i <= m; i++) {
        if (a%i== 0 && b%i == 0) return i;
    }
    return -1;
}

/* Example
    For a = 12 and b = 13, the output should be
    leastCommonPrimeDivisor(a, b) = -1;
    For a = 12 and b = 18, the output should be
    leastCommonPrimeDivisor(a, b) = 2. */
