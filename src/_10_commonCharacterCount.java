package Arcade_Intro;

public class _10_commonCharacterCount {
    private static final int ALPHABET_LENGTH = 26;

    private int[] stringToCharOccurrenceArray(String s){
        int[] charOccurrence = new int[ALPHABET_LENGTH];
        for(char c : s.toCharArray()) charOccurrence[c - 'a']++;
        return charOccurrence;
    }

    int commonCharacterCount(String s1, String s2) {
        int[] s1CharOccurrenceArray = stringToCharOccurrenceArray(s1);
        int[] s2CharOccurrenceArray = stringToCharOccurrenceArray(s2);
        int sum = 0;
        for(int i = 0; i < ALPHABET_LENGTH; i++){
            sum += Math.min(s1CharOccurrenceArray[i],s2CharOccurrenceArray[i]);
        }
        return sum;
    }
}
