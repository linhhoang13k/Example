package com.il.training.hackerrank.sad_examples.oct;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cesaregb on 10/10/16.
 */
@SuppressWarnings("Duplicates")
public class Median {
  public static void main(String[] args) {
    Median s = new Median();
    System.out.println(s.insert(12));
    System.out.println(s.insert(4));
    System.out.println(s.insert(5));
    System.out.println(s.insert(3));
    System.out.println(s.insert(8));
    System.out.println(s.insert(7));
  }

  PriorityQueue<Integer> maxH = new PriorityQueue<>(new DesendingSort());
  PriorityQueue<Integer> minH = new PriorityQueue<>(new AsendingSort());
  int size = 0;
  double median = 0d;

  public double insert(Integer val) {
    if (val > median) {
      minH.add(val);
    } else {
      maxH.add(val);
    }

    size++;
    if (minH.size() > maxH.size() + 1) {
      maxH.add(minH.remove());
    } else if (minH.size() + 1 < maxH.size()) {
      minH.add(maxH.remove());
    }

    if (size % 2 == 0) {
      median = (double) (minH.peek() + maxH.peek()) / 2;
    } else {
      median = (minH.size() > maxH.size()) ? minH.peek() : maxH.peek();
    }
    return median;
  }


  static class AsendingSort implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return one - two;
    }
  }

  static class DesendingSort implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return two - one;
    }
  }
}
