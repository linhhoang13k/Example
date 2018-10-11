package com.il.training.codefights.varios;

import java.util.*;

/**
 * Created by cesaregb on 1/9/17.
 */
public class TvProblem {

  public static void tvOn(ArrayList<String> timeInterval) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (String s : timeInterval) {
      s = s.replaceAll("[()]", "");
      String[] interval = s.split(",");
      map.put(Integer.valueOf(interval[0]), Integer.valueOf(interval[1]));
    }
    int newStart;
    int newEnd;
    Set<Integer> startTime = map.keySet();
    ArrayList<Integer> start = new ArrayList<>(startTime);
    Collections.sort(start);
    for (int k = 0; k < start.size(); k++) {
      if (start.get(k) == -1)
        continue;
      for (int i = k + 1; i < start.size(); i++) {
        if (start.get(i) == -1)
          continue;

        if (start.get(i) < map.get(start.get(k))) {
          newStart = start.get(k);
          newEnd = Math.max(map.get(start.get(k)), map.get(start.get(i)));
          map.remove(start.get(i));
          start.set(i, -1);
          map.put(newStart, newEnd);
        }
      }
    }
    int sum = 0;
    for (Map.Entry entry : map.entrySet()) {
      int x = (int) entry.getKey();
      int y = (int) entry.getValue();
      sum += y - x;
    }
    System.out.println(sum);
  }

  public static void main(String[] args) {
    ArrayList<String> timeInterval = new ArrayList<String>();
    timeInterval.add("(1,4)");
    timeInterval.add("(2,9)");
    timeInterval.add("(5,8)");
    timeInterval.add("11,15");
    timeInterval.add("21,25");
    tvOn(timeInterval);

  }
}
