package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/14/17.
 * Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a palindrome.

 Example

 For st = "abcdc", the output should be
 buildPalindrome(st) = "abcdcba".


 */
public class PalindromeBuilder {

    public static String buildPalindrome(String st) {
        char c = st.charAt(st.length()-1);
        int index = st.indexOf(c);

        while(true) {
            int start = index, end = st.length() - 1;

            //Check if string is palindrome
            while(start != end) {
                if(st.charAt(start) != st.charAt(end))
                    break;
                start++;
                end--;
            }

            if(start == end || start == end-1 ) {
                //Found a palindrom between index and length-1
                //so lets substring till index

                return st + new StringBuilder(st.substring(0,index)).reverse().toString();
            } else {
                //Did not find palindrome
                //lets look at next char occurence
                index = st.indexOf(c, index+1);
            }
        }

    }

    /*
     * Take the first index
     * see if there is a patter for start++ and end-- till if start == end, then success or start = end - 1;
     * if not set index = next occurence of element
     *
     * when pattern found from index, return st + substring(0,index);
     *
     *
     * */
    public static void main(String[] args) {
        System.out.println(buildPalindrome("abcdc"));
        System.out.println(buildPalindrome("ababab"));
    }
}
