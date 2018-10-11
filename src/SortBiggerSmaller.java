package com.il.training.topics.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesaregb on 7/3/17.
 */
public class SortBiggerSmaller {

  public static void main(String[] args) {
    sortElements(new int[]{5, 3, 4, 1, 2, 6}).forEach(System.out::println);
  }


  private static List<Integer> sortElements(int[] array) {
    int kElement = array.length / 2;
    int midElement = findKElement(array, 0, array.length - 1, kElement);
    int a = 0;
    int b = 1;
    int[] result = new int[array.length];
    for (int anArray : array) {
      if (anArray < midElement) {
        result[a] = anArray;
        a += 2;
      } else {
        result[b] = anArray;
        b += 2;
      }
    }

    return arrayToList(result);
  }

  private static List<Integer> arrayToList(int[] array) {
    List<Integer> result = new ArrayList<>();
    for (int itm : array) {
      result.add(itm);
    }
    return result;
  }

  private static int findKElement(int[] array, int a, int b, int k) {
    int i = a;
    int j = b - 1;
    int pivot = array[b];
    while (i < j) {
      while (i <= j && array[i] < pivot) {
        i++;
      }
      while (i < j && array[j] > pivot) {
        j--;
      }
      swap(array, i, j);
    }
    swap(array, i, b);
    if (i == k) {
      return array[i];
    } else if (i < k) {
      return findKElement(array, i + 1, b, k);
    } else {
      return findKElement(array, a, i, k);
    }
  }

  // destructive
  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
