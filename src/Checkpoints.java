package com.il.training.interviewbit;

import java.util.ArrayList;

/**
 * Created by cesaregb on 6/4/17.
 */
public class Checkpoints {


  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> r = prettyPrint(0);

    for (int i = 0; i < r.size(); i++) {
      for (int j = 0; j < r.get(0).size(); j++) {
        System.out.print(r.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  //	https://www.interviewbit.com/problems/prettyprint/
  public static ArrayList<ArrayList<Integer>> prettyPrint(int input) {
    if (input == 0) {
      return new ArrayList<ArrayList<Integer>>();
    }
    int size = input + (input - 1);
    int[][] result = new int[size][size];
    size--;

    int level = 0;
    int pos = input;
    for (int i = level; i <= size - i; i++) {
      for (int j = i; j <= size - i; j++) {
        result[i][j] = pos;
        result[j][size - i] = pos;

        result[size - i][size - j] = pos;
        result[size - j][i] = pos;
      }
      level++;
      pos--;
    }

    ArrayList<ArrayList<Integer>> r = new ArrayList<>();
    int index = 0;
    for (int[] arr : result) {
      r.add(new ArrayList<>());
      for (int i : arr) {
        r.get(index).add(i);
      }
      index++;
    }
    return r;
  }

}
