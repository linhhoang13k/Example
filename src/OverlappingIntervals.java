package com.il.training.interviewbit.arrays.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
  Created by cesaregb on 6/7/17.
*/
// https://www.interviewbit.com/problems/merge-overlapping-intervals/

public class OverlappingIntervals {

  private static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Interval{");
      sb.append("start=").append(start);
      sb.append(", end=").append(end);
      sb.append('}');
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    merge(Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)))
            .forEach(System.out::println);

    merge(Arrays.asList(
            new Interval(1, 3), new Interval(4, 6)))
            .forEach(System.out::println);
  }

  // [1,3],[2,6],[8,10],[15,18]
  public static ArrayList<Interval> merge(List<Interval> intervals) {
    intervals.sort(Comparator.comparingInt(o -> o.start));
    int prevEnd = -1;
    int index = 0;
    ArrayList<Interval> result = new ArrayList<>();

    Interval currInterval = null;
    while (index < intervals.size()) {
      Interval current = intervals.get(index);
      if (current.start > prevEnd) {
        if (currInterval != null) {
          result.add(currInterval);
        }
        currInterval = new Interval(current.start, current.end);
      }
      prevEnd = Math.max(prevEnd, current.end);
      currInterval.end = prevEnd;

      index++;
    }
    result.add(currInterval);
    return result;
  }
}
