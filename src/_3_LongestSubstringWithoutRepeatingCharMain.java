package Medium; /**
 * Created by Trung on 3/22/2017.
 */

import java.util.Hashtable;


/**
 * Problem Statement:
 *      Given a string, find the length of the longest substring without repeating characters.
 *
 *      Given "abcabcbb", the answer is "abc", which the length is 3.
 *      Given "bbbbb", the answer is "b", with the length of 1.
 *      Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 *      "pwke" is a subsequence and not a substring.
 *
 *  Solution:
 *      - Use Hashtable to track uniqueness. New one is created whenever a char was encountered earlier to track
 *      new portion of the string.
 *      - Cheated on number 95 since there are 95 characters.
 */
public class _3_LongestSubstringWithoutRepeatingCharMain {

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        if (s.length() <= 0) {
            return 0;
        }
        boolean notDone = true;
        Hashtable<Character, Integer> data = new Hashtable<>();
        while (notDone) {
            char c = s.charAt(i);
            if (data.get(c) != null) {
                i = data.get(c) + 1;
                break;
            }
            data.put(c, i);
            i++;
            if (i == s.length()) {
                notDone = false;
            }

        }
        if (data.size() == 95) //found the largest possible substring without repeating characters
        {
            return 95;
        }
        int l = lengthOfLongestSubstring(s.substring(i, s.length()));
        return (data.size() <= l) ? l : data.size();
    }

    public static void main(String...args) {
        System.out.println(lengthOfLongestSubstring("abc abc"));

    }



}
