package com.il.training.codefights.quora;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cesaregb on 1/22/17.
 */
@SuppressWarnings("Duplicates")
public class FeedOptimizer2 {

  public static void main(String[] args) {
    FeedOptimizer2 fo = new FeedOptimizer2();
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

  // usage of a global queue, to avoid callback structures.
  PriorityQueue<Event> queueEvents;

  int[][] feedOptimizer(int span, int h, int[][] events) {
    queueEvents = new PriorityQueue<>(new EventComparator());
    int eventId = 1;

    List<FeedEntry> feList = new ArrayList<>();
    for (int[] evt : events) {
      if (evt.length == 1) {
        FeedEntry fe = getEvents(h, span, evt[0]);
        System.out.println(fe.toString());
        feList.add(fe);
      } else {
        queueEvents.offer(new Event(evt[0], evt[1], evt[2], eventId++));
      }
    }

    // generate result O(n)
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

  public FeedEntry getEvents(int h, int s, int eT) {
    FeedEntry fe = new FeedEntry();
    // not used initially
    PriorityQueue<Event> q2 = new PriorityQueue<>(new EventComparator());
    System.out.print("\t");
    while (h > 0 && !queueEvents.isEmpty()) {
      Event e = queueEvents.remove();
      if (e.time + s >= eT) {
        if (h - e.height >= 0) {
          fe.addEvent(e);
          h -= e.height;
        }
        q2.offer(e);
      }
    }
    System.out.println();
    queueEvents = q2;
    return fe;
  }

  static class FeedEntry {
    int score;
    PriorityQueue<Integer> ids;

    public FeedEntry() {
      ids = new PriorityQueue<>(Comparator.comparingInt(a -> a));
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

      final StringBuilder sb = new StringBuilder("FeedEntry{");
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

  static class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event o1, Event o2) {
      if (o1.score == o2.score) {
        return o1.time - o2.time;
      }
      return o2.score - o1.score;
    }
  }

}
