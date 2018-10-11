package com.il.training.topics.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cesaregb on 6/12/17.
 */
public class SortedArrayOfArrays {

  public static void main(String[] args) {
    List<List<Integer>> input = new ArrayList<>();
    input.add(Stream.of(1, 2, 3, 4).collect(Collectors.toList()));
    input.add(Stream.of(2, 3, 4, 6).collect(Collectors.toList()));
    input.add(Stream.of(100, 101, 102).collect(Collectors.toList()));
    SortedArrayOfArrays foo = new SortedArrayOfArrays(input);
    while (foo.hasNext()) {
      System.out.println(foo.next());
    }
  }

  PriorityQueue<List<Integer>> dataset = new PriorityQueue<>((o1, o2) -> {
    if (o1.size() > 0 && o2.size() > 0) {
      return o1.get(0) - o2.get(0);
    } else if (o1.size() > 0) {
      return 1;
    } else {
      return 0;
    }
  });

  public int next() {
    List<Integer> list = dataset.remove();
    Integer element = list.get(0);
    list.remove(0);
    if (list.size() > 0) {
      dataset.offer(list);
    }
    return element;
  }

  public boolean hasNext() {
    return !dataset.isEmpty();
  }

  public SortedArrayOfArrays(List<List<Integer>> list) {
    for (List<Integer> l : list) {
      if (l.size() > 0) {
        dataset.offer(l);
      }
    }
  }
}
