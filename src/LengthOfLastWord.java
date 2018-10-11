package com.il.training.interviewbit.strings;

/**
 * Created by cesaregb on 6/12/17.
 */

//https://www.interviewbit.com/problems/length-of-last-word/
public class LengthOfLastWord {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("abcd alkad "));
    System.out.println(lengthOfLastWord("abcd alkad"));
    System.out.println(lengthOfLastWord("alkad"));
  }

  public static int lengthOfLastWord(final String a) {
    boolean found = false;
    int result = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
      char c = a.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        found = true;
        result++;
      } else if (found) {
        return result;
      }

    }

    return result;

  }
}
