package com.paigeruppel.interviewpractice.numbertheory;

public class RationalNumber {

//	private int numerator;
//	private int denominator;
	private int greatestCommonDivisor;
	private int[] ratio = new int[2];

	public RationalNumber(int numerator, int denominator) {
//		this.numerator = numerator;
//		this.denominator = denominator;
		greatestCommonDivisor = findGreatestCommonDivisor(numerator, denominator);
		ratio[0] = numerator / greatestCommonDivisor;
		ratio[1] = denominator / greatestCommonDivisor;
	}

	public int[] simplifyRational() {
		flipNegative();
		return ratio;
	}

	private int findGreatestCommonDivisor(int a, int b) {
		return b == 0 ? a : findGreatestCommonDivisor(b, a % b);
	}

	private void flipNegative() {
		if (ratio[1] < 0) {
			ratio[0] = -ratio[0];
			ratio[1] = -ratio[1];
		}
	}

}
