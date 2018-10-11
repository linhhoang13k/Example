package in.mkp.basic.level9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mkumar on 3/7/17.
 */
public class LongestDigitsPrefix {

    public static void main(final String[] args) {
        LongestDigitsPrefix prefixMatcher = new LongestDigitsPrefix();
        prefixMatcher.longestDigitsPrefix("8789008KLOPObhjj");
    }

    String longestDigitsPrefix(String inputString) {
        final String patternString = "\\A\\d+";

        final Pattern pattern = Pattern.compile(patternString);
        final Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
