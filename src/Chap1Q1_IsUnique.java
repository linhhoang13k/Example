package Array_Strings;

import java.util.Hashtable;

/**
 * Created by Trung on 5/30/2017.
 *
 * <p>Problem statement: Determine of a given string contains only unique characters. What if you can't use additional
 * data structures?</p>
 *
 *  Solution:
 *     With data structure: Use HashTable to map distinct characters.
 *     Without data structures:
 *
 */
public class Chap1Q1_IsUnique {

    /**
     * Complexity:
     *      Time: O(n)
     *      Space: O(n)
     * */
    public static boolean isUnique(String arg) {
        Hashtable<Character, Integer> map = new Hashtable<>();
        for (int i =0 ; i < arg.length(); i++) {
            if (map.get(arg.charAt(i)) != null && map.get(arg.charAt(i)) > 0) { //element exists
                return false;
            } else {
                map.put(arg.charAt(i), 1);
            }
        }
        return true;
    }

    /**
     * Complexity:
     *      Time: O(n*n)
     *      Space: O(1)
     * */
    public static boolean isUniqueWithNoDataStructure(String arg) {
        for (int i = 0; i < arg.length(); i++) {
            char c = arg.charAt(i);
             for (int j = i + 1; j < arg.length(); j++) {
                if (arg.charAt(j) == c) {
                    return false;
                }
             }
        }
        return true;
    }

}
