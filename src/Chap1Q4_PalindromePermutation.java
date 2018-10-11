package Array_Strings;

import java.util.*;

/**
 * Created by Trung on 6/8/2017.
 *
 * Problem statement: Given a string, determine if its permutations are palindrome.
 *
 * Example: Input: "tact coa"
 *          Output: True ("taco cat", "atco cota", ...)
 */
public class Chap1Q4_PalindromePermutation {

    public static boolean palindromePermutation(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
               if (!map.containsKey(c)) {
                   map.put(c, 1);
               } else {
                   map.put(c, map.get(c) + 1);
               }
            }
        }
        Set<Character> set = map.keySet();
        Iterator<Character> itr = set.iterator();
        boolean foundOdd = false;
        while (itr != null && itr.hasNext()) {
            Character c = itr.next();
            if (map.get(c.charValue()) % 2 == 1) {      //Found an odd count
                if (foundOdd) {     //Already found an odd count once, if foundOdd is true, then the string has
                                    //more than one character that has odd count.
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String...args) {
        System.out.println(palindromePermutation("tact coa"));
        System.out.println(palindromePermutation("ac b"));
        System.out.println(palindromePermutation("a a b b"));
        System.out.println(palindromePermutation("a a b  c c"));



    }





}
