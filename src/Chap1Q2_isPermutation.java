/**
 * Created by Trung on 2/18/2017.
 */
package Array_Strings;

import java.util.HashMap;

/***
 * Given two string, determine of one is permutation of the other.
 * Example: s1 = "abcd", s2 = "bdca" => Return true.
 *          s1 = "abcd", s2 = "bdda" => Return false;
 * Solution:
 *      HashMap one of the string
 *      Check character counts of the other string, each time decrease the char's mapping value by 1.
 *      If the value < 0, return false since two string has same lengths but not same character counts.
 *      Otherwise return true.
 */
public class Chap1Q2_isPermutation {

    public static boolean isPermutation(String s1, String s2) {
        if(s1.length() <= 0 || s2.length() <= 0 || (s1.length() != s2.length())) return false;
        else {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                if (map.containsKey(s1.charAt(i))) {
                    map.put(s1.charAt(i), map.get(s1.charAt(i)));
                } else {
                    map.put(s1.charAt(i), 1);
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (map.containsKey(s2.charAt(i))) {
                    if (map.get(s2.charAt(i)) - 1 < 0) return false;
                     map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
                }
            }
            return true;
        }

    }

}
