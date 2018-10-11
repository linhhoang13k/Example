package com.il.training.copied;

/**
 * Created by cesaregb on 12/1/16.
 */
public class RegexT1 {
  public static void main(String[] args) {
    System.out.println(isMatch("abc", "abc*"));
    System.out.println(isMatch("abc", "abc?"));
    System.out.println(isMatch("", "abc*"));
  }


  public static boolean isMatch(String s, String p) {
    if (s.isEmpty() && p.isEmpty()) return true;
    if (p.isEmpty()) return false;
    if (s.isEmpty()) {
      return isAllStar(p);
    }

    char sC = s.charAt(0);
    char pC = p.charAt(0);
    if (pC == '*') {
      boolean res = isMatch(s, p.substring(1));
      if (!res) {
        res = isMatch(s.substring(1), p);
      }
      return res;
    } else if (pC == '?' || sC == pC) {
      return isMatch(s.substring(1), p.substring(1));
    }
    return false;
  }

  private static boolean isAllStar(final String p) {
    for (char c : p.toCharArray()) {
      if (c != '*') return false;
    }
    return true;
  }
}
