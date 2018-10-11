package com.il.training.topics.recusion;

/**
 * Created by cesaregb on 4/7/17.
 */
public class DifferentWords {
  public static void main(String[] args) {

    difWords("", "hola", 0);

    difWords2("", "hola", 0);

  }


  private static void difWords(String carry, String inp, int index) {
    if (index >= inp.length()) {
      return;
    }
    char c = inp.charAt(index);
    System.out.println(carry + c);
    difWords(carry, inp, index + 1);
    difWords(carry + c, inp, index + 1);
  }

  private static void difWords2(String carry, String inp, int index) {
    if (index >= inp.length()) {
      return;
    }

    for (int i = index; i < inp.length(); i++) {
      char c = inp.charAt(i);
      String carry2 = carry + c;
      System.out.println(carry2);
      difWords2(carry2, inp, i + 1);

    }
  }
}
