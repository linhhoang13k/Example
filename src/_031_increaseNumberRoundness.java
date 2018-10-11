package Arcade_Core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _031_increaseNumberRoundness {
    boolean increaseNumberRoundness(int n) {
        Pattern pattern = Pattern.compile("0[1-9]");
        Matcher matcher = pattern.matcher(Integer.toString(n));
        return matcher.find();
    }

    boolean increaseNumberRoundnessOneLiner(int n) {
        return (n+"").matches(".*0[^0]+0*");
    }
}
