package interviewpractice.counting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author benmakusha
 */
public class StringPermutations {

    String[] stringPermutations(String s) {
        ArrayList<String> resultStr = new ArrayList<>();
        permutation(resultStr, "", s);
        String[] result = resultStr.toArray(new String[resultStr.size()]);
        Arrays.sort(result);
        return result;
    }

    void permutation(ArrayList<String> some, String l, String s) {
        if (s.length() == 0) {
            if (!some.contains(l))
                some.add(l);
        } else {
            for (int i = 0; i < s.length(); i++) {
                permutation(some, l + s.charAt(i),
                        s.substring(0, i) + s.substring(i+1, s.length()));
            }
        }
    }

}
