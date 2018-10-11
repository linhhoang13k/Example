package com.il.training.codefights.asana;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cesaregb on 11/28/16.
 */
@SuppressWarnings("Duplicates")
public class HtmlTags {
  public static void main(String[] args) {
    HtmlTags t = new HtmlTags();
    System.out.println(t.generateHTML("<div><p><img /></p><b></b></div>"));
  }

  public String generateHTML(String input) {
    Queue<Integer> queue = new LinkedList<>();
    int i = 0;
    while (i < input.length()) {
      i++;
      Character c = input.charAt(i);
      if (c == 'd') {
        i += 4;
        queue.offer(0);
      }
      if (c == 'p') {
        i += 2;
        queue.offer(1);
      }
      if (c == 'b') {
        i += 2;
        queue.offer(2);
      }
      if (c == 'i') {
        i += 6;
        queue.offer(6);
      }
      if (c == '/') {
        i++;
        c = input.charAt(i);
        if (c == 'd') {
          i += 4;
          queue.offer(3);
        }
        if (c == 'p') {
          i += 2;
          queue.offer(4);
        }
        if (c == 'b') {
          i += 2;
          queue.offer(5);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int cOpen = 0;
    int lVal = -1;
    while (!queue.isEmpty()) {
      int val = queue.remove();
      if (val <= 2) {
        cOpen++;
        if (cOpen > 1 && (lVal > 2 && lVal < 6)) {
          sb.append(", ");
        }
      } else if (val <= 5) {
        cOpen--;
      }
      lVal = val;
      sb.append(getEncodedTag(val));
    }

    return sb.toString();
  }

  static String getEncodedTag(int val) {
    if (val == 0) {
      return "DIV([";
    }
    if (val == 1) {
      return "P([";
    }
    if (val == 2) {
      return "B([";
    }
    if (val > 2 && val < 6) {
      return "])";
    }
    if (val == 6) {
      return "IMG({})";
    }
    return null;
  }

}
