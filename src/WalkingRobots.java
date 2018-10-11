package com.il.training.hackerrank.h101Hack48;

import com.il.training.hackerrank.JavaTemplate;

import java.util.Scanner;

/**
 * Created by cesaregb on 5/1/17.
 */
public class WalkingRobots {

  static int howManyCollisions(String s) {
    char last = s.charAt(0);
    int rCount = (last == 'r') ? 1 : 0;
    int result = 0;
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      int val = calculateSub(String.valueOf(last) + c);
      if (val > 0) {
        val += (last == 'r') ? (rCount - 1) : rCount;
        last = 'd';
        rCount = 0;
      } else {
        last = c;
        rCount += (last == 'r') ? 1 : 0;
      }
      result += val;
    }
    return result;
  }

  static int calculateSub(String s) {
    int val = 0;
    switch (s) {
      case "rl":
        val = 2;
        break;
      case "dl":
        val = 1;
        break;
      case "rd":
        val = 1;
        break;
    }
    return val;
  }


  public static void main(String[] args) {
    Scanner in = JavaTemplate.getFileScanner("h101Hack48/walkingrobots1.txt");
//		Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      // Returns the number of times moving robots collide.
      int result = howManyCollisions(s);
      System.out.println(result);
    }
    in.close();
  }
}
