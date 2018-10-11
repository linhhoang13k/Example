package com.il.training.hackerrank.sad_examples.test1;

import java.util.Scanner;

public class Template {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      String[] arr = new String[]{"aaa"};
      Integer[] aaa = new Integer[2];
      int i = 0;
      while (sc.hasNext()) {
        System.out.println(++i + " - " + sc.nextLine());
        // System.out.println(++i + " - " + sc.nextInt());
        //sc.next();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sc.close();
      sc = null;
    }
  }
}
