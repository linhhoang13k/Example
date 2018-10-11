package com.ctci.misc.examples;

public class StringPermutation {

    public static void permutation(String str, String whitelistedString) {
        //If the input string is empty print remaining string
        if(str.isEmpty()) {
            System.out.println(whitelistedString);
            return;
        }

        //Take a character from string and add to whitelisted String
        //Also create a string without that character and call this same method
        for(int i=0;i<str.length();i++) {
            String originalStringMinusChar = str.substring(0,i) + str.substring(i+1);
            String newWhitelistedString = whitelistedString + str.charAt(i);
            permutation(originalStringMinusChar, newWhitelistedString);
        }
    }


    public static void main(String[] args) {
	    permutation("helo", "");
    }
}
