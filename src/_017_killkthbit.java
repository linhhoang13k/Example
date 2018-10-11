package Arcade_Core;

public class _017_killkthbit {
    int killKthBit(int n, int k) {
        return n & (~(1 << k - 1)) ;
    }

    int killKthBit2(int n, int k) {
        return ~(n & (int)Math.pow(2, k - 1)) & n;
    }
}
