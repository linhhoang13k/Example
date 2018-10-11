package Arcade_Core;

public class _005_MaxMultiple {
    int maxMultiple(int divisor, int bound) {
        return bound - (bound % divisor);
    }
}
