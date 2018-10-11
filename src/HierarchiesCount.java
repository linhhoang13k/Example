class HierarchiesCount {
    static int MODULO;

    int hierarchiesCount(int n, int[][] respectList) {
        if (n == 1) {
            return 1;
        }
        MODULO = 1_000_000_007;
        long[][] mat = new long[n][n];
        for (int[] v : respectList) {
            mat[v[0]][v[1]] = -1;
            mat[v[1]][v[0]] = -1;
            mat[v[0]][v[0]]++;
            mat[v[1]][v[1]]++;
        }

        int k = (n * det(mat, n - 1)) % MODULO;
        if (k < 0) {
            k += MODULO;
            k %= MODULO;
        }
        return k;
    }

    int det(long[][] mat, int n) {
        ArrayList<Long> laterDiv = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (mat[j][i - 1] == 0 || mat[i - 1][i - 1] == 0) {
                    continue;
                }
                long _gcd = gcd(mat[i - 1][i - 1], mat[j][i - 1]);
                long rowMult = ((mat[i - 1][i - 1] * modInverse(_gcd, MODULO)) % MODULO + MODULO) % MODULO;
                long subMult = ((mat[j][i - 1] * modInverse(_gcd, MODULO)) % MODULO + MODULO) % MODULO;
                laterDiv.add(rowMult);
                for (int k = i; k < n; k++) {
                    mat[j][k] = (((mat[j][k] * rowMult) % MODULO - (mat[i - 1][k] * subMult) % MODULO) % MODULO
                            + MODULO) % MODULO;
                }
            }
        }
        long ans = 1;
        for (int i = 0; i < n; i++) {
            if (mat[i][i] < 0) {
                mat[i][i] = (mat[i][i] % MODULO + MODULO) % MODULO;
            }
            ans = (ans * mat[i][i]) % MODULO;
        }
        for (long d : laterDiv) {
            if (d < 0) {
                d += MODULO;
                d %= MODULO;
            }
            ans = (ans * modInverse(d, MODULO)) % MODULO;
        }
        if (ans < 0) {
            ans += MODULO;
            ans %= MODULO;
        }
        return (int) ans;
    }

    long modInverse(long a, long m) {
        long _m = m;
        long temp;
        long q;
        long x = 0;
        long y = 1;
        while (a > 1) {
            temp = m;
            q = a / m;
            m = a % m;
            a = temp;
            temp = x;
            x = y - q * x;
            y = temp;
        }
        if (y < 0) {
            y += _m;
        }
        return y;
    }

    long gcd(long a, long b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b, a % b);
    }
}