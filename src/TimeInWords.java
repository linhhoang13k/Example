package com.il.training.topics.implmementation;

/**
 * Created by cesaregb on 12/28/16.
 * https://www.hackerrank.com/challenges/the-time-in-words
 */
public class TimeInWords {

  private static final String[] numNames = {
          "", // avoid mins for 20 or 30
          "one",
          "two",
          "three",
          "four",
          "five",
          "six",
          "seven",
          "eight",
          "nine",
          "ten",
          "eleven",
          "twelve",
          "thirteen",
          "fourteen",
          "fifteen",
          "sixteen",
          "seventeen",
          "eighteen",
          "nineteen"
  };

  private static final String[] tensNames = {
          "ten",
          "twenty",
          "half"
  };

  private static String getMins(int m) {
    if (m == 0) {
      return "o' clock";
    } else if (m == 15) {
      return "quarter";
    } else if (m == 30) {
      return "half";
    } else {
      if (m < 20) {
        return numNames[m] + " minutes";
      } else {
        return tensNames[(m / 10) - 1] + " " + numNames[m % 10] + " minutes";
      }
    }
  }

  private static String getHour(int h) {
    return numNames[h];
  }

  private static String getHour(int h, int m) {
    StringBuilder result = new StringBuilder();
    if (m == 0) {
      result.append(getHour(h)).append(" ").append(getMins(m));
    } else if (m <= 30) {
      result.append(getMins(m)).append(" past ").append(getHour(h));
    } else {
      m = 60 - m;
      h++;
      result.append(getMins(m)).append(" to ").append(getHour(h));
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(getHour(7, 29));
  }

}
