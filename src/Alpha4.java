package com.il.training.codefights.varios;

/**
 * Created by cesaregb on 12/28/16.
 */
public class Alpha4 {

  public static void main(String[] args) {
//		System.out.println(getCharVal('a'));
//		System.out.println(getCharVal('z'));

    String s = "fivec";
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {

      sum += ((int) s.charAt(i)) - 97;
      if ((i + 1) % 4 == 0) {
        sb.append(sum % 4);
        sum = 0;
      }
    }

    if (s.length() % 4 != 0) {
      sb.append(sum % 4);
    }
    System.out.println(sb.toString());
  }
}
