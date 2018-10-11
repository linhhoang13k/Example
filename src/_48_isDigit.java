package Arcade_Intro;

public class _48_isDigit {
    boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    boolean isDigitOther(char symbol) {
        return Character.isDigit(symbol);
    }
}
