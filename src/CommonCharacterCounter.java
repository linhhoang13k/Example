package com.codefights.arcade.intro;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 3/30/17.
 * Given two strings, find the number of common characters between them.

 Example

 For s1 = "aabcc" and s2 = "adcaa", the output should be
 commonCharacterCount(s1, s2) = 3.

 Strings have 3 common characters - 2 "a"s and 1 "c".
 */
public class CommonCharacterCounter {


    public static int commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> stringOneCount = new HashMap<>();
        Map<Character, Integer> stringTwoCount = new HashMap<>();

        for(char c : s1.toCharArray()) {
            if(stringOneCount.get(c) != null) {
                stringOneCount.put(c, stringOneCount.get(c) + 1);
            } else {
                stringOneCount.put(c, 1);
            }
        }

        for(char c : s2.toCharArray()) {
            if(stringOneCount.get(c) != null) {
                if(stringTwoCount.get(c) != null) {
                    stringTwoCount.put(c, stringTwoCount.get(c) + 1);
                } else {
                    stringTwoCount.put(c, 1);
                }
            }
        }


        int count = 0;
        for(Map.Entry<Character, Integer> entry : stringOneCount.entrySet()){
            if(stringTwoCount.get(entry.getKey()) != null)
            if(stringTwoCount.get(entry.getKey()) < entry.getValue()){
                count+=stringTwoCount.get(entry.getKey());
            } else {
                count+=entry.getValue();
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(commonCharacterCount("aabcc","adcaa"));
    }


}
