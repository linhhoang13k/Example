package com.il.training.interviewbit.arrays.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 6/7/17.
 */
@SuppressWarnings("Duplicates")
public class MergeIntervals {

  public static void main(String[] args) {
    insert(Arrays.asList(
            new Interval(1, 2),
            new Interval(3, 6))
            , new Interval(10, 8)).forEach(System.out::println);
  }

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

  public static ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
    int index = 0;
    ArrayList<Interval> result = new ArrayList<>();

    // add the fist ones
    while (index < intervals.size()
            && intervals.get(index).end < newInterval.start) {

      result.add(intervals.get(index));
      index++;
    }
    if (index == intervals.size()
            || newInterval.start < intervals.get(index).start && newInterval.end < intervals.get(index).start) {
      result.add(newInterval);
    } else {
      Interval mergedInterval = new Interval(newInterval.start, newInterval.end); // clone
      while (index < intervals.size()
              && (newInterval.start < intervals.get(index).start && newInterval.end > intervals.get(index).end
              || newInterval.start > intervals.get(index).start && newInterval.start < intervals.get(index).end
              || newInterval.end > intervals.get(index).start && newInterval.end < intervals.get(index).end)
              ) {
        mergedInterval = mergeIntervals(mergedInterval, intervals.get(index));
        index++;
      }
      result.add(mergedInterval);
    }

    // add the last ones
    while (index < intervals.size()
            && intervals.get(index).start > newInterval.end) {

      result.add(intervals.get(index));
      index++;
    }
    return result;
  }

  private static Interval mergeIntervals(Interval a, Interval b) {
    return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
  }
}
