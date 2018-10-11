package com.il.training.hackerrank.ctci;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cesaregb on 12/2/16.
 */
public class CalancedBrackets {

  private static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '[' || c == '{' || c == '(') {
        stack.push(c);
      } else {
        if (stack.size() == 0) {
          return false;
        }
        Character t = stack.pop();
        if (c == ')' && t != '(') {
          return false;
        } else if (c == '}' && t != '{') {
          return false;
        } else if (c == ']' && t != '[') {
          return false;
        }
      }
    }
    return stack.size() <= 0;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      boolean answer = isBalanced(expression);
      if (answer)
        System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
