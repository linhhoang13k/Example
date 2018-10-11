package com.il.training.leetcode;

import java.util.HashMap;

/**
 * Created by cesaregb on 3/22/17.
 * https://leetcode.com/problems/minimum-window-substring/#/description
 */
public class MinimunWindowSubstring {
  public static void main(String[] args) {
    MinimunWindowSubstring s = new MinimunWindowSubstring();

    System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
  }


  public String minWindow(String s, String t) {
    if (t.length() > s.length())
      return "";

    String result = "";

    //character counter for t
    HashMap<Character, Integer> target = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      target.putIfAbsent(c, 0);
      target.put(c, target.get(c) + 1);
    }

    // character counter for s
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int minLen = s.length() + 1;

    int count = 0; // the total of mapped characters

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (target.containsKey(c)) {
        map.putIfAbsent(c, 0);
        map.put(c, map.get(c) + 1);
        if (map.get(c) <= target.get(c)) {
          count++;
        }
      }

      if (count == t.length()) {
        char sc = s.charAt(left);

        while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
          if (map.containsKey(sc) && map.get(sc) > target.get(sc))
            map.put(sc, map.get(sc) - 1);
          System.out.println(sc);
          left++;
          sc = s.charAt(left);
        }

        if (i - left + 1 < minLen) {
          result = s.substring(left, i + 1);
          minLen = i - left + 1;
        }
      }
    }

    return result;
  }

}
