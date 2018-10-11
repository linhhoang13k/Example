package Arcade_Intro;

public class _03_checkPalindrome {
    boolean checkPalindrome(String inputString) {
        return inputString.equals(new StringBuilder(inputString).reverse().toString());
    }
}

