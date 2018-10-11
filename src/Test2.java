package com.il.training.hackerrank.sad_examples.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * Download the file wl.txt from:

   http://goo.gl/IjsCxX

"Anagram": An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word 
or phrase using all the original letters exactly once; for example, the letters from 'icon' can be rearranged into 'coin'. 
The word is NOT an anagram of itself.

Devise a function that takes one parameter W and returns all the anagrams of W from the file wl.txt.

anagrams("beat") should return ["beta", "bate"]
 * */

public class Test2 {
  public static void main(String[] args) {
    for (String item : getAnagrams("beat")) {
      System.out.println(item);
    }
  }

  public static String[] getAnagrams(String w) {
    List<String> items = getFileContent();
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> chars = new HashMap<>();
    for (int i = 0; i < w.length(); i++) {
      String key = String.valueOf(w.charAt(i));
      Integer val = (chars.get(key) != null) ? chars.get(key) + 1 : 1;
      chars.put(key, val);
    }

    for (String line : items) {
      if (line.length() == w.length()) {
        boolean add = true;
        int i = 0;
        while (add && i < w.length()) {
          String key = String.valueOf(line.charAt(i));
          if (chars.get(key) != null && chars.get(key) > 0) {
            chars.put(key, chars.get(key) - 1);
          } else {
            add = false;
          }
          i++;
        }
        if (add) {
          result.add(line);
        }
        // Reset the hashmap
        chars = new HashMap<>();
        for (i = 0; i < w.length(); i++) {
          String key = String.valueOf(w.charAt(i));
          Integer val = (chars.get(key) != null) ? chars.get(key) + 1 : 1;
          chars.put(key, val);
        }
      }
    }
    return result.toArray(new String[result.size()]);
  }

  public static List<String> getFileContent() {
    BufferedReader br = null;
    List<String> result = new ArrayList<>();
    try {
      String sCurrentLine;
      URL path = Test2.class.getResource("wl.txt");
      br = new BufferedReader(new FileReader(path.getPath()));
      while ((sCurrentLine = br.readLine()) != null) {
        result.add(sCurrentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }
}