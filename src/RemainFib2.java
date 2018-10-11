package com.il.training.codefights.marathons;

/**
 * Created by cesaregb on 12/19/16.
 */
@SuppressWarnings("Duplicates")
public class RemainFib2 {

  public static void main(String[] args) {
//		System.out.println(getNumber(5));
//		System.out.println(getNumber("8"));

    System.out.println(sumStrings("9", "9"));
  }

  private static String getNumber(String number) {
    int a = 3;  // initial fib
    long n = Integer.valueOf(number);
    long r = 0;
    while (n > 0) {
      r = fibonacciL(a++) - 1;
      n -= r;
    }
    long tmp = fibonacciL(a) + (r + n);
    return String.valueOf(tmp);
  }

  private static long[] memmoL = new long[1000];

  private static long fibonacciL(int n) {
    if (memmoL[n] > 0) {
      return memmoL[n];
    }
    if (n == 1 || n == 2) {
      memmoL[n] = 1;
    } else {
      memmoL[n] = fibonacciL(n - 1) + fibonacciL(n - 2);
    }
    return memmoL[n];
  }


  private static String[] memmo = new String[1000];

  private static String fibonacci(int n) {
    if (memmo[n].length() > 0) {
      return memmo[n];
    }
    if (n == 1 || n == 2) {
      memmo[n] = "1";
    } else {
      memmo[n] = sumStrings(fibonacci(n - 1), fibonacci(n - 2));
    }
    return memmo[n];
  }

  private static String sumStrings(String a, String b) {
    StringBuilder result = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0 || carry > 0) {
      int v = carry;
      if (i >= 0) {
        v += Character.getNumericValue(a.charAt(i));
      }
      if (j >= 0) {
        v += Character.getNumericValue(b.charAt(j));
      }
      int d = v % 10;
      result.append(d);
      carry = v / 10;
      i--;
      j--;
    }
    return result.reverse().toString();
  }

  private static String substractStrings(String aS, String bS) {
    StringBuilder result = new StringBuilder();
    int i = aS.length() - 1;
    int j = bS.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0 || carry > 0) {
      int a = Character.getNumericValue(aS.charAt(i));
      int b = Character.getNumericValue(bS.charAt(j));
      int c = 0;
      if (a > b) {
        c = a - b;
      } else {
        if (i > 0) {
          a += 10;
          carry = 1;
        } else {

        }
      }
    }
    return result.reverse().toString();
  }


//	private static Long getNumber(long thNoFib){
//		if (thNoFib == 1)
//			return 4l;
//
//		int itr = 5;
//		long prev = 0;
//		long current = 0;
//
//		// why of size 4?
//		Stack<Long> stack = new Stack<>();
//		// will stop when we have iterated thru the fibs diff until we get the num we want..
//		while(stack.size() < thNoFib){
//			itr++;
//			prev = fibonacci(itr-1);
//			current = fibonacci(itr);
//			// iterate while fib(x -1) < fib(x) and stack.size < theNoFib...
//			while(prev < current && stack.size() < thNoFib){
//				prev++;
//				stack.push(prev);
//			}
//
//		}
//		return stack.pop();
//	}


}
