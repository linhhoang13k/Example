package arcadeintro.divingdeeper;
/*
For s = "cabca", the output should be
differentSymbolsNaive(s) = 3.
 */

import java.util.Arrays;

public class DifferentSymbolNaive {
    public static void main(String[] args) {
        String input = "cabca";

    }

    private static int differentSymbolsNaive(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        int counter = 1;
        for (int i = 0; i < letters.length - 1; i++)
            if (letters[i] != letters[i + 1]) {
                counter++;
            }
        return counter;
    }

}
