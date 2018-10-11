package in.mkp.basic.level12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mkumar on 3/16/17.
 */
public class LongestWord {

    public static void main(final String[] args) {
        LongestWord longestWord = new LongestWord();
        //System.out.println(">"+longestWord.longestWord("Ready, steady      steady ,$%%&^&***)   go!")+"<");
        System.out.println(">"+longestWord.longestWord("A!! AA[]z")+"<");
    }

    String longestWord(String text) {
        final String regex = "[A-Za-z]*";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);

        String longestString = "";
        int longestLen=0;
        while (matcher.find()) {
            final String token = matcher.group();
            final int lenToken = token.length();
            if (lenToken > longestLen) {
                longestString = token;
                longestLen = lenToken;
            }
        }
        return longestString;
    }

}
