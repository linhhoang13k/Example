package Arcade_Intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _40_longestDigitsPrefix {
    String longestDigitsPrefix(String inputString) {
        Pattern p = Pattern.compile("^[\\d]+");
        Matcher m = p.matcher(inputString);
        if(m.find()){
             return inputString.substring(m.start(), m.end());
        }
        return "";
    }

    String longestDigitsPrefixOneLiner(String inputString) {
        return inputString.replaceAll("^(\\d*).*", "$1");
    }
}
