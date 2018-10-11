package interviewpractice.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author benmakusha
 */
public class SortByString {

    String sortByString(String s, String t) {
        int tracker = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), tracker++);
        }
        char[] charArray = s.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            for (int k = j + 1; k < charArray.length; k++) {
                if (map.get(charArray[j]) > map.get(charArray[k])) {
                    char xFactor = charArray[j];
                    charArray[j] = charArray[k];
                    charArray[k] = xFactor;
                }
            }
        }
        return new String(charArray);
    }
}
