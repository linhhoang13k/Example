package Arcade_Intro;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class _09_allLongestStrings {
    String[] allLongestStrings(String[] inputArray) {
        // Sort it, to get max length stored in inputArray[inputArray.length -1]
        Arrays.sort(inputArray, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return Arrays.stream(inputArray).filter(currentString ->
                currentString.length() == inputArray[inputArray.length - 1].length()).toArray(String[]::new);
    }
}
