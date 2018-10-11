package com.il.training.hackerrank.easy;

import com.il.training.hackerrank.JavaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cesaregb on 3/19/17.
 */
@SuppressWarnings("Duplicates")
public class CircularArrayRotation {

  public static void main(String[] args) throws Exception {
    List<String> lines = getFileLines(JavaTemplate.getFileScanner("easy/CircularArrayRotation/test1.txt"));
    solution2(lines);

  }

  private static void solution1(List<String> lines) {
    int n = Integer.valueOf(lines.get(0).split(" ")[0]);
    int k = Integer.valueOf(lines.get(0).split(" ")[1]);
    int q = Integer.valueOf(lines.get(0).split(" ")[2]);
    int[] elements = new int[n];
    String[] pTmp = lines.get(1).split(" ");
    for (int i = 0; i < pTmp.length; i++) {
      elements[i] = Integer.valueOf(pTmp[i]);
    }
    // clean k
    k = k % n;
    for (int i = 2; i < lines.size(); i++) {
      int queryItem = Integer.valueOf(lines.get(i));
      queryItem = queryItem - k;
      queryItem = (queryItem >= 0) ? queryItem : (n + queryItem);
      System.out.println(elements[queryItem]);
    }
  }

  private static void solution2(List<String> lines) {
    int n = Integer.valueOf(lines.get(0).split(" ")[0]);
    int k = Integer.valueOf(lines.get(0).split(" ")[1]);
    int[] elements = new int[n];
    String[] pTmp = lines.get(1).split(" ");
    for (int i = 0; i < pTmp.length; i++) {
      elements[i] = Integer.valueOf(pTmp[i]);
    }

    k = k % n;
    //length of first part
    int a = elements.length - k;

    reverse(elements, 0, a - 1);
    reverse(elements, a, elements.length - 1);
    reverse(elements, 0, elements.length - 1);

    for (int i = 2; i < lines.size(); i++) {
      int queryItem = Integer.valueOf(lines.get(i));
      System.out.println(elements[queryItem]);
    }
  }

  private static void reverse(int[] elements, int a, int b) {
    if (elements == null || elements.length == 1)
      return;
    while (a < b) {
      int tmp = elements[a];
      elements[a++] = elements[b];
      elements[b--] = tmp;
    }
  }


  private static List<String> getFileLines(Scanner in) {
    List<String> stringArrayList = new ArrayList<>();
    String input = null;
    while (in.hasNextLine() && !((input = in.nextLine()).equals(""))) {
      stringArrayList.add(input);
    }
    return stringArrayList;
  }

}
