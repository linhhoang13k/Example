package com.iub.coding.practice.CodeName47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MaxNExtInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * int x = 218765, tempInt = 0, buf = 0, dec = 0; //12345 StringBuffer
		 * sb1 = new StringBuffer(x); char[] buff =
		 * sb1.toString().toCharArray();
		 * 
		 * Arrays.sort(buff);
		 * 
		 * StringBuffer sb2 = new StringBuffer(new String(buff));
		 * 
		 * while(dec < sb1.length()) {
		 * 
		 * 
		 * }
		 * 
		 * tempInt = x; int[] temp = new int[10];
		 * 
		 * while(tempInt != 0) {
		 * 
		 * buf = tempInt%10; temp[buf]++; tempInt = tempInt/10; dec++; }
		 * 
		 * tempInt = 0; for(int i = 0; i < 10; i++) {
		 * 
		 * while(temp[i] != 0 && dec >= 0) {
		 * 
		 * tempInt += Math.pow(10, dec) * temp[i];
		 * 
		 * dec--; } }
		 * 
		 * while(tempInt <= x) {
		 * 
		 * tempInt = (tempInt) }
		 * 
		 * 
		 * 
		 */
		int arr[] = {5, 4, 3, 2, 1};
		
		int l = 0, r = arr.length, globalAnd = -1, j;

		int max1 = 0, max2 = 0;

		for (int i = 0; i < arr.length - 1; i++) {

		
			max1 = arr[i];
			max2 = arr[i + 1];

			for (j = i + 1; j < arr.length; j++) {

				if (arr[j] > max1) {
					max2 = max1;
					max1 = arr[j];

				} else if (arr[j] > max2)
					max2 = arr[j];

				System.out.println(max1 + "\t" + max2);
				if ((max1 & max2) > globalAnd) {

					globalAnd = (max1 & max2);
					l = i;
					r = j;
				} else if ((max1 & max2) == globalAnd && (r - l) > (j - i)) {

					globalAnd = (max1 & max2);
					l = i;
					r = j;
				}
			}

		}

		System.out.println(l + "\t" + r);
	}

}
