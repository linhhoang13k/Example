package CodeFightsTasks;

/**
 * Created by Pasha on 23.01.2018.
 */
public class CFTask10 {
    int commonCharacterCount(String s1, String s2) {
        int amountOfOccurrences = 0;
        StringBuilder stringBuilder1 = new StringBuilder(s1);
        StringBuilder stringBuilder2 = new StringBuilder(s2);
        for (int i = 0; i < s1.length(); i++) {
            if (stringBuilder2.indexOf(String.valueOf(stringBuilder1.charAt(i))) != -1) {
                stringBuilder2.deleteCharAt(stringBuilder2.indexOf(String.valueOf(stringBuilder1.charAt(i))));
                amountOfOccurrences++;
            }
        }
        return amountOfOccurrences;
    }

}
