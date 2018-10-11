package com.il.training.general;

/**
 * Created by cesaregb on 1/17/17.
 */
public class Multiplications {

  public static void main(String[] args) {
    System.out.println(tableOf(3));
  }

  private static String tableOf(int n) {
    StringBuilder sb = new StringBuilder();
    sb.append(n);
    for (int i = 2; i <= 10; i++) {
      sb.append("\n").append(i * n);

    }
    return sb.toString();
  }

}
