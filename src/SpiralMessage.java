package com.il.training.hackerrank.easy;

import java.util.Scanner;

/**
 * Created by cesaregb on 1/26/17.
 */
@SuppressWarnings("Duplicates")
public class SpiralMessage {


  public static void main1(String[] args) {
    String[] input = new String[]{
            "a##ar",
            "a#aa#",
            "xxwsr"
    };

    int n = 3;
    int m = 5;

    System.out.println(countWords(input, n, m));
  }

  public static void main2(String[] args) {
    String[] input = new String[]{
            "phqghume#ylnlfdxfirc"
    };

    int n = 1;
    int m = 20;

    System.out.println(countWords(input, n, m));
  }

  public static void main3(String[] args) {
    String[] input = new String[]{
            "a#sar",
            "a#a##",
            "xxwsr",
            "rrrrr"
    };

    int n = 4;
    int m = 5;

    System.out.println(countWords(input, n, m));
  }

  public static void main4(String[] args) {
    String[] input = new String[]{
            "ph#g#ume#yl#lf#xf#r#",
            "#scxggbwkfnqduxwff#o",
            "z##rtkjprepggxrpn#v#",
            "stmwcysyycqpevik#ffm",
            "#nimkkasvwsrenzkycx#",
            "xtlsgypsfadpooefxzbc",
            "#ejuvpvaboygpoeylfpb",
            "npljvrvipyamyehwqnq#",
            "###xujjloovaowuxwhms",
            "ncbxcoksfzkvatxdknly",
            "jyhfixjswnkkufnuxxzr",
            "zbmnmgqooketlyhnkoau",
            "###rcddiuteiojwayyz#",
            "vscmpsajlfvgubfaaovl",
            "zylntrkdcpwsrtesjwh#",
            "izcobzcnfwlqijtvdwvx",
            "###bldvgylwgbusb#bor",
            "xtlhcsmpxohgmgnke#fd",
            "###ogbgxpeyanfetcc#e",
            "pzshkljugggekjdq#je#"
    };

    int n = 20;
    int m = 20;

    System.out.println(countWords(input, n, m));
  }

  public static void main5(String[] args) {
    String[] input = new String[]{
            "#h",
            "qg"
    };
    int n = 2;
    int m = 2;

    System.out.println(countWords(input, n, m));
  }

  public static void main(String[] args) {
    String[] input = new String[]{
            "p",
            "h",
            "q",
            "g",
            "h",
            "u",
            "m",
            "#",
            "a",
            "y",
            "l",
            "#",
            "l",
            "f",
            "d",
            "x",
            "f",
            "i",
            "r",
            "c"
    };
    int n = 20;
    int m = 1;

    System.out.println(countWords(input, n, m));
  }

  public static void mainA(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    in.nextLine();
    String[] input = new String[n];
    for (int i = 0; i <= n; i++) {
      input[i] = in.nextLine();
    }

    System.out.println(countWords(input, n, m));
  }

  static int countWords(String[] input, int n, int m) {
    if (n == 1 && m == 1) return 0;
    int nWords = 0;
    n--;
    m--;

    int rowLimit = 0;
    int colLimit = 0;

    boolean localWords = false;

    if (m == 0) {
      for (int i = n - rowLimit; i >= rowLimit; i--) {
        char c = input[i].charAt(colLimit);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      nWords += (localWords) ? 1 : 0;
      System.out.println("--" + nWords + " ");
      return nWords;
    }

    if (n == 0) {
      for (int i = (colLimit); i <= m - colLimit; i++) {
        char c = input[rowLimit].charAt(i);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      nWords += (localWords) ? 1 : 0;
      System.out.println("--" + nWords + " ");
      return nWords;
    }
    System.out.println("lakdjlkadjl");

    while (rowLimit <= n / 2 && colLimit <= m / 2) {

      for (int i = n - rowLimit; i >= rowLimit; i--) {
        char c = input[i].charAt(colLimit);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      System.out.println("--" + nWords + " ");

      for (int i = (colLimit + 1); i <= m - colLimit; i++) {
        char c = input[rowLimit].charAt(i);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      System.out.println("--" + nWords + " ");

      for (int i = (rowLimit + 1); i <= n - rowLimit; i++) {
        char c = input[i].charAt(m - colLimit);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      System.out.println("--" + nWords + " ");

      for (int i = m - (colLimit + 1); i >= colLimit + 1; i--) {
        char c = input[n - rowLimit].charAt(i);
        System.out.print(c);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      System.out.println("--" + nWords + " ");

      rowLimit++;
      colLimit++;

    }

    nWords += (localWords) ? 1 : 0;
    System.out.println("--" + nWords + " ");
    return nWords;
  }

  static int countWords2(String[] input, int n, int m) {
    if (n == 1 && m == 1) return 1;
    int nWords = 0;
    n--;
    m--;

    int rowLimit = 0;
    int colLimit = 0;
    boolean localWords = false;
    if (m == 0) {
      for (int i = n - rowLimit; i >= rowLimit; i--) {
        char c = input[i].charAt(colLimit);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      nWords += (localWords) ? 1 : 0;
      return nWords;
    }

    if (n == 0) {
      for (int i = (colLimit); i <= m - colLimit; i++) {
        char c = input[rowLimit].charAt(i);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      nWords += (localWords) ? 1 : 0;
      return nWords;
    }

    while (rowLimit <= n / 2 && colLimit <= m / 2) {

      for (int i = n - rowLimit; i >= rowLimit; i--) {
        char c = input[i].charAt(colLimit);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }

      for (int i = (colLimit + 1); i <= m - colLimit; i++) {
        char c = input[rowLimit].charAt(i);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }


      for (int i = (rowLimit + 1); i <= n - rowLimit; i++) {
        char c = input[i].charAt(m - colLimit);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }

      for (int i = m - (colLimit + 1); i >= colLimit + 1; i--) {
        char c = input[n - rowLimit].charAt(i);
        nWords += ((c == '#') && localWords) ? 1 : 0;
        localWords = (c >= 'a' && c <= 'z');
      }
      rowLimit++;
      colLimit++;
    }

    nWords += (localWords) ? 1 : 0;
    return nWords;
  }
}
