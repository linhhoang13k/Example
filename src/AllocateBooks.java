package com.il.training.interviewbit.binarySearch;

import java.util.List;

/**
 * Created by cesaregb on 7/5/17.
 */
//https://www.interviewbit.com/problems/allocate-books/
public class AllocateBooks {

  public int books(List<Integer> bookPages, int reader) {
    long high = Long.MAX_VALUE;
    long low = 0;
    long mid;
    long res = 0;
    if (reader > bookPages.size()) {
      return -1;
    }
    long sum = 0;
    for (int pages : bookPages) {
      sum += pages;
    }
    while (low <= high) {
      mid = low + ((high - low) >> 1);
      if (isPossible(bookPages, reader, mid, sum)) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return (int) res;
  }

  private boolean isPossible(List<Integer> bookPages, int reader, long maxPage, long totalPages) {
    if (maxPage < totalPages / reader) {
      return false;
    }
    int index = 0;
    int n = bookPages.size();
    int i;

    for (i = 0; i < reader && index < n; i++) {
      long total = 0;
      while (total < maxPage && index < n) {
        total += bookPages.get(index);
        if (total > maxPage)
          break;
        index++;
      }
    }
    return index >= n;
  }
}
