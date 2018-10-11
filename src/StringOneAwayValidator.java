package com.ctci.chapter1;

/**
 * Created by zambro on 2/25/17.
 */
public class StringOneAwayValidator {

    private static boolean isOneCharacterReplaced(String str1, String str2) {
        boolean isFoundDifferent = false;
        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i) != str2.charAt((i))) {
                if(isFoundDifferent)
                    return false;
                else
                    isFoundDifferent = true;
            }
        }
        return true;
    }

    private static boolean isOneCharacterInserted(String str1, String str2) {
        boolean isFoundDifferent = false;
        int index1 = 0, index2 = 0;
        while(index1 < str1.length() && index2 < str2.length()) {
            if(str1.charAt(index1) != str2.charAt(index2)) {
                if(isFoundDifferent)
                    return false;
                //Move the bigger string's pointer as we have found a difference
                index1++;
                isFoundDifferent = true;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean isOneCharacterAway(String str1, String str2) {
        if(str1.length() == str2.length()) {
            return isOneCharacterReplaced(str1, str2);
        } else if(str1.length() == str2.length() + 1) {
            return isOneCharacterInserted(str1, str2);
        } else if(str1.length() + 1 == str2.length() ) {
            return  isOneCharacterInserted(str2, str1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOneCharacterAway("abc","abd"));
        System.out.println(isOneCharacterAway("abc","abe"));
        System.out.println(isOneCharacterAway("abc","abce"));
        System.out.println(isOneCharacterAway("abce","abc"));
        System.out.println(isOneCharacterAway("pale","bake"));
    }
}
