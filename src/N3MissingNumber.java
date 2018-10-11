package com.il.training.interviewbit.arrays.java;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cesaregb on 6/10/17.
 */

//https://www.interviewbit.com/problems/n3-repeat-number/
public class N3MissingNumber {

  public int repeatedNumber(final List<Integer> inputList) {
    int treshhold = inputList.size() / 3;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inputList.size(); i++) {
      map.putIfAbsent(inputList.get(i), 0);
      map.put(inputList.get(i), map.get(inputList.get(i)) + 1);
      if (map.get(inputList.get(i)) > treshhold) {
        return inputList.get(i);
      }
    }
    return -1;
  }
}
