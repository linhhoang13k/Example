package in.mkp.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkumar on 3/10/17.
 */
public class ReverseChallenge {

    public static  void main(String args[]) {
        ReverseChallenge reverseChallenge = new ReverseChallenge();
        System.out.println(reverseChallenge.reverseChallenge("codefights"));
    }

    String reverseChallenge(String s) {
        final String[] tokens = s.split(" ");
        final List<Integer> locationOfSpaces = populateLocationOfSpaces(s);

        final StringBuilder sb = new StringBuilder();

        for (int i=tokens.length-1; i >= 0; --i) {
            sb.append(reverseWord(tokens[i]));
        }

        final String stringWithoutSpaces = sb.toString();
        final int lenOriginalString = s.length();
        final int lenNewString = stringWithoutSpaces.length();
        String result = "";
        for (int i=0, j=0; i < lenOriginalString && j <= lenNewString; ++i) {
            if (locationOfSpaces.contains(i)) {
                result += " ";
            }
            else {
                result += stringWithoutSpaces.charAt(j);
                ++j;
            }
        }

        return result;
    }

    String reverseWord(final String s) {
        final int len = s.length();
        final char[] chars = new char[len];
        final String reversedString = new StringBuilder(s).reverse().toString();

        for (int i=0; i < len; ++i) {
            chars[i] = (char)((char)'z' - (char)(reversedString.charAt(i) - 'a'));
        }

        return new String(chars);

    }

    List<Integer> populateLocationOfSpaces(final String s) {
        final List<Integer> locations = new ArrayList<>();
        final int len = s.length();
        for (int i=0; i < len; ++i) {
            if (s.charAt(i) == ' ') {
                locations.add(i);
            }
        }
        return locations;
    }

}
