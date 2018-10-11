package Arcade_Intro;

import java.util.Arrays;

public class _28_alphabeticShift {
    String alphabeticShift(String inputString) {
        return new String(inputString.chars().map(
                currentChar -> (currentChar - 'a' + 1) % 26 + 'a').toArray(), 0, inputString.length());
    }
}
