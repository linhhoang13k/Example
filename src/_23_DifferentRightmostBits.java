package Arcade_Core;

public class _23_DifferentRightmostBits {
    int differentRightmostBit(int n, int m) {
        return (((n ^ m) - 1) ^  (n ^ m)) & (n ^ m);
    }
}
