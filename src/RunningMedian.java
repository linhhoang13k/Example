package com.il.training.hackerrank.ctci;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("Duplicates")
public class RunningMedian {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    RunningMedian s = new RunningMedian();
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
      System.out.println(s.insert(a[a_i]));
    }
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
