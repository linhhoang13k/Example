package Arcade_Intro;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _52_longestWord {
    String longestWord(String text) {
        Matcher m = Pattern.compile("[\\w]+").matcher(text);

        int maxLength = 0;
        String maxWord = "";
        while(m.find()){
            if(text.substring(m.start(), m.end()).length() > maxLength){
                maxLength = text.substring(m.start(), m.end()).length();
                maxWord = text.substring(m.start(), m.end());
            }
        }
        return maxWord;
    }

    String longestWordOneLiner(String text) {
        return Arrays.stream(text.split("\\W+")).max((a,b) -> a.length() - b.length()).get();
    }
}
