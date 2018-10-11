package com.paigeruppel.interviewpractice.dynamicprogramming.basic;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class Staircase {

	// you can take the staircase 1 or 2 steps at a time
	// return the total possible ways to climb a staircase with n steps
	public int climbingStairs(int n) {
		n++;
		double root5 = Math.pow(5, 0.5);
		double result = 1/root5*( Math.pow((1+root5)/2, n) - Math.pow((1-root5)/2, n) );
		return (int)(result);
//		int nFib = fibonacci(n);
//		int nLessOneFib = fibonacci(n - 1);
//		return nFib + nLessOneFib;
	}

	private int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
