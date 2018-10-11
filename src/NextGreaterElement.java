package com.il.training.hackerrank.hard;

import com.il.training.hackerrank.JavaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cesaregb on 3/20/17.
 */
public class NextGreaterElement {

  public static void main(String[] args) throws Exception {
    List<String> lines = getFileLines(JavaTemplate.getFileScanner("hard/nge/test1.txt"));
    String[] sElements = lines.get(1).split("\\s+");
    int[] elements = new int[sElements.length];
    int i = 0;
    for (String e : sElements) {
      elements[i++] = Integer.valueOf(e);
    }

    int[] result = getNGE(elements);
    for (i = 0; i < elements.length; i++) {
      System.out.println(elements[i] + " " + result[i]);
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

  private static int[] getNGE(int[] elements) {
    Stack<KeyValue> stack = new Stack<>();
    int[] result = new int[elements.length];

    stack.add(new KeyValue(0, elements[0]));
    for (int i = 1; i < elements.length; i++) {
      while (!stack.isEmpty() && elements[i] > stack.peek().value) {
        KeyValue kv = stack.pop();
        result[kv.key] = elements[i];
      }
      stack.push(new KeyValue(i, elements[i]));
    }
    while (!stack.isEmpty()) {
      KeyValue kv = stack.pop();
      result[kv.key] = -1;
    }

    return result;
  }

  public static class KeyValue {
    int key;
    int value;

    KeyValue(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append(key).append(" ").append(value);
      return sb.toString();
    }
  }
}
