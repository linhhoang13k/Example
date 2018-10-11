package evg.codefights.core;

import java.util.regex.*;

public class RegularHell {

    public static void main(String[] args) {
        System.out.println(new RegularHell().repetitionEncryption("Hi, hi Jane! I'm so. So glad to to finally be able to write - WRITE!! - to you!"));
    }

    boolean isSentenceCorrect(String sentence) {
        String regex = "^[A-Z]+[^\\.\\?\\!]*[\\.\\?\\!]$";
        return sentence.matches(regex);
    }

    String replaceAllDigitsRegExp(String input) {
        return input.replaceAll("\\d", "#");
    }


    String swapAdjacentWords(String s) {
        return s.replaceAll("(\\b\\w+) (\\w*\\b)", "$2 $1");
    }

    String nthNumber(String s, int n) {
        Pattern pattern = Pattern.compile("(?:[\\D0]+)*(?:\\d+[\\D0]+){" + (n - 1) + "}(\\d+).*");

        Matcher matcher = pattern.matcher(s);
        matcher.matches();
        return matcher.group(1);
    }

    boolean isSubsequence(String t, String s) {
        String pattern = "";
        for (int i = 0; i < s.length(); i++) {
            pattern += "[\\w\\W]*" + Pattern.quote("" + s.charAt(i));
        }
        Pattern regex = Pattern.compile(pattern);
        System.out.println(regex);
        return regex.matcher(t).find();
    }

    Boolean eyeRhyme(String pairOfLines) {
        Pattern pattern = Pattern.compile("^.*(.{3})\t.*(.{3})$");
        Matcher matcher = pattern.matcher(pairOfLines);
        matcher.matches();
        return matcher.group(1).equals(matcher.group(2));
    }

    String programTranslation(String solution, String[] args) {
        String argumentVariants = String.join("|", args);
        String pattern = "(?<=[^0-9a-zA-Z$_])(" + argumentVariants + ")(?=[^0-9a-zA-Z$_])";
        String sub = "\\$$1" ;
        return solution.replaceAll(pattern, sub);
    }

    int repetitionEncryption(String letter) {
        Pattern pattern = Pattern.compile("(?i)([A-Za-z]+)[^a-zA-Z]+\\1(?![A-Za-z]+)");
        Matcher matcher = pattern.matcher(letter);

        int res = 0;
        while (matcher.find()) {
            res++;
        }
        return res;
    }

    int bugsAndBugfixes(String rules) {
        Pattern pattern = Pattern.compile("(\\d*)d(\\d+)([\\+\\-]\\d+)*");
        Matcher m = pattern.matcher(rules);

        int res = 0;
        while (m.find()) {
            int rolls = m.group(1).isEmpty() ? 1 : Integer.parseInt(m.group(1));
            int dieType = Integer.parseInt(m.group(2));
            int formulaMax = rolls * dieType;

            if (m.group(3) != null && !m.group(3).isEmpty()) {
                if (m.group(3).charAt(0) == '-') {
                    formulaMax -= Integer.parseInt(m.group(3).substring(1));
                }
                else {
                    formulaMax += Integer.parseInt(m.group(3).substring(1));
                }
            }

            res += formulaMax;
        }

        return res;
    }

}
