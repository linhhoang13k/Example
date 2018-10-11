package com.il.training.hackerrank.sad_examples.oct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cesaregb on 10/3/16.
 */
@SuppressWarnings("Duplicates")
public class NumberNeeded {

  public static int numberNeeded(String first, String second) {
    int difA = 0;
    int difB = 0;

    HashMap<Character, Integer> m1 = new HashMap<>();
    HashMap<Character, Integer> m2 = new HashMap<>();
    // a
    for (int i = 0; i < first.length(); i++) {
      Character c = first.charAt(i);
      m1.putIfAbsent(c, 0);
      m1.put(c, m1.get(c) + 1);
    }

    // b
    for (int i = 0; i < second.length(); i++) {
      Character c = second.charAt(i);
      m2.putIfAbsent(c, 0);
      m2.put(c, m2.get(c) + 1);
    }

    for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();

      if (m2.get(key) != null) {
        difA += Math.abs(value - m2.get(key));
        m2.remove(key);
      } else {
        difA += value;
      }
      m1.remove(key, 0);
    }

    for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();

      if (m1.get(key) != null) {
        difB += Math.abs(value - m2.get(key));
      } else {
        difB += value;
      }
    }
    return difA + difB;
  }


  public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String a = in.next();
//		String b = in.next();
    System.out.println(numberNeeded("aaa", "aaaaa"));
  }

}


