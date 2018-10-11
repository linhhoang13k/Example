package com.iub.coding.practice.CodeName47;

import java.math.BigInteger;

public class NonRepeatedNumbers {

	public static void main(String[] args) {

		String small = "";
		String big = "";

		long count = 0, multiplier = 1;

		if (small.length() >= 10)
			System.out.println(0);

		int pow = small.length();

		while (pow <= big.length() && pow < 10) {

			multiplier = 10;

			for (int i = 0; i < pow; i++) {

				/*
				 * if(i == 0) { multiplier = 10 -
				 * Character.getNumericValue(small.charAt(i)); }else {
				 * 
				 * multiplier = 10 - i; }
				 */

				/*
				 * Case 1 pow = small length
				 */

				if (pow == small.length()) {

					if (i == 0) {
						count = count * (10 - Character.getNumericValue(small.charAt(i)));
					} else {

						count = count * (10 - i);
						count -= Character.getNumericValue(small.charAt(i)) * Math.pow(10, i);
					}
				} else if (pow == big.length()) {

					if (i == 0) {
						count = count * Character.getNumericValue(small.charAt(i));
					} else {

						count = count * (10 - i);
						count -= Character.getNumericValue(small.charAt(i)) * Math.pow(10, i);
					}
				}

			}
		}

	}

}
