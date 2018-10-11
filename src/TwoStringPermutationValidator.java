package com.ctci.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 2/20/17.
 */
public class TwoStringPermutationValidator {

    public static boolean isPermutation(String str1, String str2) {
        //Sort string 1
        str1 = sortStringAscending(str1);
        //Sort string 2
        str2 = sortStringAscending(str2);

        return str1.equals(str2);
    }

    public static boolean isPermutationUsingHashMap(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
        char[] charactersInString1 = str1.toCharArray();
        for(char c:charactersInString1) {
            if(characterCount.containsKey(c)) {
                characterCount.put(c, characterCount.get(c)+1);
            } else {
                characterCount.put(c, 1);
            }
        }

        char[] charactersInString2 = str2.toCharArray();
        for(char c:charactersInString2) {
            if(characterCount.containsKey(c)) {
                Integer count = characterCount.get(c);
                count--;
                if(count < 0) {
                    return false;
                }
                characterCount.put(c,count);
            } else {
                return false;
            }
        }
        return true;
    }

    private static String sortStringAscending(String str) {
        char[] charactersInString = str.toCharArray();
        Arrays.sort(charactersInString);
        return new String(charactersInString);
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("hello","olhel"));
        System.out.println(isPermutation("hello","ohel"));
        System.out.println();
        System.out.println(isPermutationUsingHashMap("hello","olhel"));
        System.out.println(isPermutationUsingHashMap("hello","zzzz"));
        System.out.println(isPermutationUsingHashMap("hello","hellllo"));
        System.out.println(isPermutationUsingHashMap("hello","ohel"));
    }
}
