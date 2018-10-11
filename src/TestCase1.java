package com.il.amazon;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cesaregb on 7/17/17.
 */
@SuppressWarnings("Duplicates")
public class TestCase1 {


  public static void main(String[] args) {
    TestCase1 tc = new TestCase1();
    List<Integer> r = tc.getAnagrams("abdc92929292aabcd9292", "abcd");
    System.out.println(Joiner.on(",").join(r));
//
//    System.out.println("_____");
//    r = tc.getAnagrams("a", "abcd");
//    System.out.println(Joiner.on(",").join(r));
//
//    System.out.println("_____");
//    r = tc.getAnagrams("abdcg92929292aabcde9292", "");
//    System.out.println(Joiner.on(",").join(r));
//
    System.out.println("_____");
    r = tc.getAnagrams("0000000", "000");
    System.out.println(Joiner.on(",").join(r));
  }


  public List<Integer> getAnagrams(String haystack, String needle) {
    return findStringRabinKarp(haystack, needle);
//    return brureForce(haystack, needle);
  }

  public List<Integer> brureForce(String haystack, String needle) {
    HashMap<Character, Integer> needleMap = new HashMap<>();
    for (int i = 0; i < needle.length(); i++) {
      Character c = needle.charAt(i);
      needleMap.putIfAbsent(c, 0);
      needleMap.put(c, needleMap.get(c) + 1);
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < haystack.length(); i++) {
      Character c = haystack.charAt(i);

      if (needleMap.containsKey(c)) {
        // make a copy of it O(n * m); where m = chars in needle; n = chars in haystack
        HashMap<Character, Integer> copy = new HashMap<>(needleMap);
        int j = i;
        // Explore this found, this inner loop make it O (n ^ 2)
        while (copy.containsKey(c) && copy.get(c) > 0 && j < haystack.length()) {
          copy.put(c, copy.get(c) - 1);
          j++;
          if (j < haystack.length()) {
            c = haystack.charAt(j);
          }
        }

        int distance = (j - i);
        if (distance == needle.length()) {
          result.add(i);
        }
      }
    }
    // O (m + n ^ 2);
    return result;
  }


  private boolean compareMaps(HashMap<Character, Integer> mapA, HashMap<Character, Integer> mapB) {
    try {
      for (Character k : mapB.keySet()) {
        if (!mapA.get(k).equals(mapB.get(k))) {
          return false;
        }
      }
      for (Character y : mapA.keySet()) {
        if (!mapA.get(y).equals(mapB.get(y))) {
          return false;
        }
      }
    } catch (NullPointerException np) {
      return false;
    }
    return true;
  }


  List<Integer> findStringRabinKarp(String haystack, String needle) {
    List<Integer> result = new ArrayList<>();
    // repeated code could be externalized on a method.
    HashMap<Character, Integer> needleMap = new HashMap<>();
    for (int i = 0; i < needle.length(); i++) {
      Character c = needle.charAt(i);
      needleMap.putIfAbsent(c, 0);
      needleMap.put(c, needleMap.get(c) + 1);
    }

    if (needle.length() == 0 || needle.length() > haystack.length()) {
      return result;
    }

    int len = needle.length();
    HashMap<Character, Integer> helperMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      Character c = haystack.charAt(i);
      helperMap.putIfAbsent(c, 0);
      helperMap.put(c, helperMap.get(c) + 1);
    }


    int i = len;
    while (i <= haystack.length()) {
      if (compareMaps(needleMap, helperMap)) {
        result.add(i - len);
      }

      if (i < haystack.length()) {
        Character removeChar = haystack.charAt(i - len);
        Character c = haystack.charAt(i);

        helperMap.put(removeChar, helperMap.get(removeChar) - 1);
        if (helperMap.get(removeChar) == 0){
          helperMap.remove(removeChar);
        }

        helperMap.putIfAbsent(c, 0);
        helperMap.put(c, helperMap.get(c) + 1);
      }
      i++;
    }
    return result;
  }


}
