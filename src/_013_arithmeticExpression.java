package Arcade_Core;

public class _013_arithmeticExpression {
    boolean arithmeticExpression(int a, int b, int c) {
        return a - b == c || a + b == c || a * b == c || a / (double)b == c;
    }
}
