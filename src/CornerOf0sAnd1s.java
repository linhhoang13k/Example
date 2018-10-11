package evg.codefights.core;

public class CornerOf0sAnd1s {

    public static void main(String[] args) {
        System.out.println(new CornerOf0sAnd1s().arrayPacking(new int[]{24, 85, 0}));
    }

    int killKthBit(int n, int k) {
        return n & ~(1 << k - 1);
    }

    int arrayPacking(int[] a) {
        int M = 0;
        for (int i = 0; i < a.length; i++) {
            int m = a[i] << (8 * i);
            M |= m;
        }
        return M;
    }

    int rangeBitCount(int a, int b) {
        int res = 0;

        for (int i = a; i <= b; i++) {
            for (int j = 0; j < 5; j++) {
                if (((1 << j) & i) != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    int mirrorBits(int x) {
        int b = 0;
        while (x != 0) {
            b <<= 1;
            b |= (x & 1);
            x >>= 1;
        }
        return b;
    }

    int secondRightmostZeroBit(int n) {
        return (~(n + ((~n) & (n + 1)))) & (n + ((~n) & (n + 1)) + 1);
    }

    int swapAdjacentBits(int n) {
        return ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
    }

    int differentRightmostBit(int n, int m) {
        return ((n ^ m) & (-(n ^ m)));
    }

    int equalPairOfBits(int n, int m) {
        return n + m + 1 & ~m - n;
    }
}
