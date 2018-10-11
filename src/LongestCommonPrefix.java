package com.il.training.interviewbit.strings;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 6/11/17.
 */
//https://www.interviewbit.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(Arrays.asList("abcdefgh", "aefghijk", "abcefgh")));
    System.out.println(longestCommonPrefix(Arrays.asList("abc", "abcdef", "abcdef")));
    System.out.println(longestCommonPrefix(Arrays.asList("aaa", "bbb", "ccc")));


  }


  public static String longestCommonPrefix(List<String> strings) {
    int min = Integer.MAX_VALUE;
    String minString = "";
    for (int i = 0; i < strings.size(); i++) {
      String s = strings.get(i);
      if (s.length() < min) {
        minString = s;
        min = s.length();
      }
    }
    StringBuilder sb = new StringBuilder();
    boolean flag = true;
    int i = 0;
    while (flag && i < min) {
      char c = minString.charAt(i);
      for (int j = 0; j < strings.size(); j++) {
        if (strings.get(j).charAt(i) != c) {
          flag = false;
        }
      }
      if (flag) {
        sb.append(c);
      }
      i++;
    }
    return sb.toString();
  }


}
