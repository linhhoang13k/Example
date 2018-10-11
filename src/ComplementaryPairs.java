package com.il.walletHub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by cesaregb on 10/2/16.
 */
public class ComplementaryPairs {
  public static void main(String[] args) {
    try {
      List<String> inputs = getFileContent("test/ComplementaryPairs.txt");
      int k = 0;
      for (String it :
              inputs) {
        it = it.replaceAll("\\s+", "");
        if (it.contains(",")) {
          int[] v = Stream.of(it.split(",")).mapToInt(Integer::parseInt).toArray();
          System.out.println(findKcomplementary(k, v));
        } else {
          k = Integer.valueOf(it);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.print("Error processing file.");
    }
  }

  // complexity big O = O(n) we iterate thru the array only once.
  // space big O = O (n + m); n = input array, m different elements in the array.
  public static Integer findKcomplementary(int k, int[] arr) {
    Integer result = 0;
    HashMap<Integer, Integer> helper = new HashMap<Integer, Integer>();
    // function not using, stream to use java 6 compatible functions.
    for (int it : arr) {
      int missing = k - it;
      if (helper.get(missing) != null) {
        result += helper.get(missing);
      }
      helper.putIfAbsent(it, 0); // initialize if absent
      helper.put(it, (helper.get(it) + 1)); // increment
    }
    return result;
  }

  private static List<String> getFileContent(String fileName) throws Exception {
    BufferedReader br = null;
    List<String> result = new ArrayList<>();
    try {
      String sCurrentLine;
      URL path = ComplementaryPairs.class.getResource(fileName);
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
