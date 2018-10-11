package com.il.training.hackerrank.ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */

public class RansomNote {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();

    HashMap<String, Integer> m1 = new HashMap<>();
    HashSet<String> m2 = new HashSet<>();

    for (int magazine_i = 0; magazine_i < m; magazine_i++) {
      String txt = in.next();
      m1.putIfAbsent(txt, 0);
      m1.put(txt, m1.get(txt) + 1);
    }

    boolean result = true;
    for (int ransom_i = 0; ransom_i < n; ransom_i++) {
      String txt = in.next();
      m1.putIfAbsent(txt, 0);
      m1.put(txt, m1.get(txt) - 1);
      m2.add(txt);
    }

    for (Map.Entry<String, Integer> entry : m1.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      if (m2.contains(key) && value < 0) {
        result = false;
      }
    }

    String resultString = (result) ? "Yes" : "No";
    System.out.println(resultString);
  }
}
