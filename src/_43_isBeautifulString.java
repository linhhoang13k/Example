package Arcade_Intro;

import java.util.ArrayList;

public class _43_isBeautifulString {
    boolean isBeautifulString(String inputString) {
        int[] charOccurrenceMap = new int[26];

        for(char c : inputString.toCharArray()) charOccurrenceMap[c - 'a']++;

        for(int i = 1; i < charOccurrenceMap.length; i++)
            if(charOccurrenceMap[i-1] < charOccurrenceMap[i]) return false;

        return true;
    }
}
