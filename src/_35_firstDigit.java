package Arcade_Intro;

public class _35_firstDigit {
    char firstDigit(String inputString) {
        return inputString.replaceAll("[^0-9]", "").charAt(0);
    }
}
