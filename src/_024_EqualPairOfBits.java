package Arcade_Core;

public class _024_EqualPairOfBits {
    int equalPairOfBits(int n, int m) {
        return ~(n ^ m) & ~(~(n ^ m)-1);
    }
}
