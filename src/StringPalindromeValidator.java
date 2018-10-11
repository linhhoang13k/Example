package com.ctci.chapter1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zambro on 2/25/17.
 */
public class StringPalindromeValidator {

    public static boolean doesPalindromeExist(String str) {
        char[] charArray = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : charArray) {
            if(charMap.get(c) == null) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, charMap.get(c)+1);
            }
        }

        boolean isOddFound = false;
        Iterator iterator = charMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry) iterator.next();
            if(entry.getValue() % 2 != 0) {
                if(isOddFound) {
                    return false;
                } else {
                    isOddFound = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(doesPalindromeExist("cac"));
        System.out.println(doesPalindromeExist("cat"));
        System.out.println(doesPalindromeExist("taccat"));
        System.out.println(doesPalindromeExist("tacat"));
        System.out.println(doesPalindromeExist("tacact"));
        System.out.println(doesPalindromeExist("tacagt"));
    }
}
