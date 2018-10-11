class GoodStringsCount {
    int goodStringsCount(int len) {
        return C(26, len) * ((int) Math.pow(2, len) - len - 1);
    }

    int C(int n, int r) {
        if (r > n / 2) {
            r = n - r;
        } // because C(n, r) == C(n, n - r)
        int ans = 1;
        int i;

        for (i = 1; i <= r; i++) {
            ans *= n - r + i;
            ans /= i;
        }

        return ans;
    }
}