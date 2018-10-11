package Arcade_Core;

public class _006_CircleOfNumbers {
    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }
}
