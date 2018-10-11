package Arcade_Intro;

public class _18_palindromeRearranging {
    boolean palindromeRearranging(String inputString) {
        int[] occurrencesOfLetters = new int[26];

        // Full up occurrence table
        for(int i = 0; i < inputString.length(); i++){
            occurrencesOfLetters[inputString.charAt(i) - 'a']++;
        }

        // Check if each value occurs even times. May 1 char can have odd occurrence number.
        int oddFound = 0;
        for(int i = 0; i < occurrencesOfLetters.length; i++){
            if(occurrencesOfLetters[i] % 2 != 0) oddFound++;
        }
        return oddFound == 0 || oddFound == 1;
    }
}
