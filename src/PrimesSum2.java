class PrimesSum2 {
    int primesSum2(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] p = new boolean[n + 1];
        p[1] = true;
        for (int i = 1; i <= n; i++) {
            if (p[i] == true) {
                continue;
            }
            for (int j = 2; j * i <= n; j++) {
                p[j * i] = true;
            }
        }
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (!p[i]) {
                sum += i % 1000000007;
                sum = sum % 1000000007;
            }
        }
        return sum;
    }
}