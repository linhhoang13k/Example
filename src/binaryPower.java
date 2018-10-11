int binaryPower(int n, int k) {
    int M = (int) 1e7 + 7;
    return k == 0 ? 1 
                  : k % 2 == 0 
                  ? binaryPower((int) (((long) n * n) % M), k / 2) 
                  : (int) (((long) binaryPower(n, k - 1) * n) % M);
}
