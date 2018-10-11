package com.sleepsoft.tests;

/**
 * Created by agermenos on 6/8/16.
 */
public class StringReverse {
    private String reverseString(String originalString){
        char[] values = originalString.toCharArray();
        char[] returnChars = new char[values.length];
        for (int k=0; k<values.length; k++) {
            returnChars[k]=values[values.length-k-1];
        }
        return new String(returnChars);
    }

    public static void main(String args[]){
        final String STRING = "This is my original String";
        StringReverse stringReverse = new StringReverse();
        System.out.println("Original String: \t\t" + STRING);
        System.out.println("Reversing the String: \t" + stringReverse.reverseString(STRING));
    }
}
