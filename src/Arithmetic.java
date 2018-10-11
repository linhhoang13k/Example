package exercise13;

public class Arithmetic {

    public boolean isArithmeticExpression(int a, int b, int c) {
       return a + b == c || a - b == c || a * b == c || a / b == c;
    }
}
