package com.il.training.interviewbit.binarySearch;

/**
 * Created by cesaregb on 7/4/17.
 */

//https://www.longerviewbit.com/problems/square-root-of-longeger/
public class FindSqrt {

  public static void main(String[] args) {
    System.out.println(sqrt(11));
    System.out.println(sqrt(2147483647));
    System.out.println(sqrt(913337620));
  }

  public static long sqrt(long a) {
    return sqrtIterative(a);
  }


  public static long sqrtIterative(long a) {
    if (a == 0) {
      return 0;
    }
    if (a == 1) {
      return 1;
    }
    long dif = a;
    long current = a;
    while (true) {
      dif /= 2;
      dif = (dif > 0) ? dif : 1;
      long result = current * current;
      long r2 = (current + 1) * (current + 1);
      if (result == a || (result < a && r2 > a)) {
        return current;
      }
      if (result > a) {
        current -= dif;
      } else {
        current += dif;
      }
    }
  }

  public static long sqrt(long a, long element) {
    long result = element * element;
    long helper = (element + 1) * (element + 1);
    if (result == a) {
      return element;
    } else if (result < a && helper > a) {
      return element;
    } else if (result > a) {
      return sqrt(a, element / 2);
    } else {
      return sqrt(a, element + (element / 2));
    }

  }

}
