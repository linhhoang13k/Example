package com.ctci.chapter1;

/**
 * Created by zambro on 2/26/17.
 */
public class StringCompressionValidator {

    public static String stringCompression(String str) {
        //Null checks
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuilder compressedString = new StringBuilder();

	/*
    Iterate through the characters and each time the next is different from current,
	add count to new string and reset count.

	Check for out of index at EOS
	*/
        int count = 0;
        for (int i = 0; i < str.length(); i++) {//i = 3
            count++; //count  = 2
            if ((i + 1) == str.length() || str.charAt(i) != str.charAt(i + 1)) { //   4 == 4 || b != b
                //Found a different character or found the end of string
                compressedString.append(str.charAt(i)); //cS = a2b
                compressedString.append(count); //cS = a2b2
                count = 0;
            }
        }


        //Return only if the compressedString length is less than input string
        return (compressedString.toString().length() < str.length()) ? compressedString.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa"));
    }
}
