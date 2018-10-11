package Arcade_Intro;

public class _30_circleOfNumbers {
    int circleOfNumbers(int n, int firstNumber) {
        return ((n/2 + firstNumber) < n ? (n/2 + firstNumber) : (n/2 + firstNumber) % n);
    }
}
