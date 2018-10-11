package com.paigeruppel.interviewpractice.numbertheory;

public class MissingNumber {

	public int findMissingNumber(int[] arr) {
		int n = arr.length;
		int expectedSum = n * (n+1) / 2;
		int actualSum = 0;
		for (int num:arr) {
			actualSum += num;
		}
		int missingNumber = expectedSum - actualSum;
		return missingNumber;
	}

}
