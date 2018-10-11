package com.codefights.challenges;

/**
 * Created by zambro on 6/16/17.
 * You may be familiar with a well-known indexOf function, which returns the position of the first occurrence of a specified value in a givenString.

 Today, your task is to implement the notIndexOf function. Given givenString and a value, this function should return the first position i of givenString, such that there's no match between any character of value and the characters of givenString starting at i. If there's no such position, it should return -1 instead.

 Example

 For givenString = "Welcome to CodeFights!" and value = "Back to school",
 the output should be
 notIndexOf(givenString, value) = 2.

 Here's why:

 At position 0, the strings Welcome to Cod and Back to school should be compared. Since the character 'o' at position 12 is a common character, it is not the answer.
 At position 1, the strings elcome to Code and Back to school should be compared. They have matching characters at positions 2 (character 'c') and 11 (character 'o').
 At position 2, the compared strings are lcome to CodeF and Back to school. They have no common characters.
 Thus, the answer is 2.

 For givenString = "Zoo" and value = "oo", the output should be
 notIndexOf(givenString, value) = -1.

 Both at positions 0 and 1, there is at least one matching character 'o' between the two strings. Thus, the answer is -1.
 */
public class NotIndexOf {

    static int notIndexof(String s, String v) {
        int n = v.length();
        for(int i=0;s.length()-i>=n;i++) {
            String x = s.substring(i,i+n);
            if(!same(x,v))
                return i;
        }
        return -1;
    }

    static boolean same(String a, String b) {
        for(int i=0;i<a.length();i++){
            if (a.charAt(i) == b.charAt(i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(notIndexof("Welcome to CodeFights","Back to school"));
        System.out.println(notIndexof("Zoo","oo"));
    }
}
