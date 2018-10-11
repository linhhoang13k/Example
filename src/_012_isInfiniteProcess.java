package Arcade_Core;

public class _012_isInfiniteProcess {
    boolean isInfiniteProcess(int a, int b) {
        return a > b || Math.abs(a - b) % 2 == 1;
    }
}
