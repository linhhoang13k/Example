package com.paigeruppel.interviewpractice.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateDetect {

	/*
	 * Note: Write a solution with O(n) time complexity and O(1) additional space
	 * complexity, since this is what you would be asked to do during a real
	 * interview.
	 * 
	 * Given an array a that contains only numbers in the range from 1 to a.length,
	 * find the first duplicate number for which the second occurrence has the
	 * minimal index. In other words, if there are more than 1 duplicated numbers,
	 * return the number for which the second occurrence has a smaller index than
	 * the second occurrence of the other number does. If there are no such
	 * elements, return -1.
	 */
	
	public int firstDuplicate(int[] a) {
		Set<Integer> found = new HashSet<>();

		int duplicate = -1;

		for (int i = 0; i < a.length && duplicate == -1; i++) {
			if (found.contains(a[i])) {
				duplicate = a[i];
			}
			found.add(a[i]);
		}

		return duplicate;
	}

}
