package com.il.training.codefights.quora;

import java.util.*;

/**
 * Created by cesaregb on 1/22/17.
 */
@SuppressWarnings("Duplicates")
public class FeedOptimizer3 {

  public static void main2(String[] args) {
    FeedOptimizer3 fo = new FeedOptimizer3();
    int[][] input = new int[][]
            {{11, 50, 30},
                    {12},
                    {13, 40, 20},
                    {14, 45, 40},
                    {15},
                    {16},
                    {18, 45, 20},
                    {21},
                    {22}};
    int[][] r = fo.feedOptimizer(10, 100, input);
  }

  public static void main(String[] args) {
    FeedOptimizer3 fo = new FeedOptimizer3();
    int[][] input = new int[][]
            {{1, 50, 25},
                    {3, 100, 50},
                    {4, 50, 25},
                    {6, 200, 50},
                    {7, 100, 25},
                    {8, 100, 25},
                    {10, 101, 25},
                    {11, 101, 25},
                    {101, 10, 10},
                    {102, 25, 25},
                    {103, 25, 25},
                    {104, 15, 15},
                    {105, 25, 25},
                    {106},
            };
    int[][] r = fo.feedOptimizer(10, 50, input);
  }

  public static void main0(String[] args) {
    FeedOptimizer3 fo = new FeedOptimizer3();
    int[][] input = new int[][]
            {{1, 50, 25},
                    {3, 100, 50},
                    {4, 50, 25},
                    {5},
                    {6, 200, 50},
                    {7, 100, 25},
                    {8, 100, 25},
                    {9},
                    {10, 101, 25},
                    {11, 101, 25},
                    {12},
                    {101, 10, 10},
                    {102, 25, 25},
                    {103, 25, 25},
                    {104, 15, 15},
                    {105, 25, 25},
                    {106},
                    {201, 20, 10},
                    {202, 20, 15},
                    {203, 40, 25},
                    {204, 40, 25},
                    {205, 40, 25},
                    {206},
                    {301, 1, 15},
                    {302},
                    {303, 1, 15},
                    {304},
                    {305, 1, 15},
                    {306},
                    {307, 1, 15},
                    {308},
                    {309, 1, 15},
                    {310},
                    {311, 1, 15},
                    {312},
                    {313, 1, 15},
                    {314}};
    int[][] r = fo.feedOptimizer(10, 50, input);
  }

  public static void main1(String[] args) {
    FeedOptimizer3 fo = new FeedOptimizer3();
    int[][] input = new int[][]
            {{2},
                    {3, 10, 50},
                    {4, 11, 50},
                    {9},
                    {10}};
    int[][] r = fo.feedOptimizer(5, 100, input);
  }

  // usage of a global queue, to avoid callback structures.
  Map<String, FeedEntry> memo = new HashMap<>();

  int[][] feedOptimizer(int span, int h, int[][] events) {
    List<Event> listEvents = new ArrayList<>();
    int eventId = 1;

    List<FeedEntry> feList = new ArrayList<>();
    for (int[] evt : events) {
      if (evt.length == 1) {
        // process refresh event...
        // O(n^2) on events.
        FeedEntry fe = getEvents(h, span, evt[0], new FeedEntry(), listEvents, 0);
        System.out.println(fe.toString());
        feList.add(fe);
      } else {
        // add new feed event
        listEvents.add(new Event(evt[0], evt[1], evt[2], eventId++));
      }
    }

    // generate result O(n)
    int[][] result = getResultFormat(feList);
    return result;
  }

  FeedEntry getEvents(int h, int s, int eventTime, FeedEntry fe, List<Event> listEvents, int index) {
    if (index == listEvents.size()) return fe;
    if (h == 0) return fe;
    if (h < 0) return null;

    String key = eventTime + "-" + h;
    if (memo.get(key) != null) {
      return memo.get(key);
    }

    Event e = listEvents.get(index++); // get current event..
    FeedEntry temporalFeedEntry = new FeedEntry(fe.score, fe.ids); // create helper for call next with current values..

    if ((e.time + s) >= eventTime) { // event fits within the time...
      if (h - e.height >= 0) { // event fits on height...
        fe.addEvent(e);

        // get me the best solution of the remaining height having being used current event.
        fe = getEvents((h - e.height), s, eventTime, fe, listEvents, index);
      }
    }

    // get the possible best solution without using the current event
    temporalFeedEntry = getEvents(h, s, eventTime, temporalFeedEntry, listEvents, index);

    // COMPARE events
    // if scores are equal get
    if (fe.score == temporalFeedEntry.score) {
      fe = (fe.ids.size() > temporalFeedEntry.ids.size()) ? temporalFeedEntry : fe;
    } else {
      fe = (temporalFeedEntry.score > fe.score) ? temporalFeedEntry : fe;
    }

    System.out.println("\t" + key + ":::" + fe.toString());
    memo.put(key, new FeedEntry(fe.score, fe.ids));
    return fe;
  }

  private int[][] getResultFormat(List<FeedEntry> feList) {
    int[][] result = new int[feList.size()][];
    int i = 0;
    for (FeedEntry fe : feList) {
      result[i] = new int[fe.ids.size() + 1];
      result[i][0] = fe.score;
      int j = 1;
      while (!fe.ids.isEmpty()) {
        result[i][j] = fe.ids.remove();
        j++;
      }
      i++;
    }
    return result;
  }

  static class FeedEntry {
    int score;
    PriorityQueue<Integer> ids;

    public FeedEntry() {
      ids = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public FeedEntry(int score, PriorityQueue<Integer> ids) {
      this.score = score;
      this.ids = new PriorityQueue<>(ids);
    }

    public void addEvent(Event e) {
      ids.offer(e.id);
      score += e.score;
    }

    @Override
    public String toString() {
      PriorityQueue<Integer> clone = new PriorityQueue<>(ids);
      final StringBuilder sb1 = new StringBuilder();
      while (!clone.isEmpty()) {
        int id = clone.remove();
        sb1.append(String.valueOf(id)).append(" ");
      }

      final StringBuilder sb = new StringBuilder("- {");
      sb.append("score=").append(score);
      sb.append(", ids=").append(sb1.toString());
      sb.append('}');
      return sb.toString();
    }
  }

  static class Event {
    int time;
    int score;
    int height;
    int id;

    public Event(int time, int score, int height, int id) {
      this.time = time;
      this.score = score;
      this.height = height;
      this.id = id;
    }
  }

}
