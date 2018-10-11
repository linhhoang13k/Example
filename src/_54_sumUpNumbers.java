package Arcade_Intro;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _54_sumUpNumbers {
    int sumUpNumbers(String inputString) {
        int sum = 0;
        Matcher m = Pattern.compile("[\\d]+").matcher(inputString);

        while(m.find()){
            sum += Integer.parseInt(inputString.substring(m.start(), m.end()));
        }
        return sum;
    }

    int sumUpNumbersOneLiner(String inputString) {
        return Arrays.stream(inputString.split("\\D+")).filter(s-> !s.isEmpty()).mapToInt(Integer::new).sum();
    }
}
