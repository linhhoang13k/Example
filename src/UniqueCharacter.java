package com.paigeruppel.interviewpractice.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueCharacter {

	/*
	 * Note: Write a solution that only iterates over the string once and uses O(1)
	 * additional memory, since this is what you would be asked to do during a real
	 * interview.
	 * 
	 * Given a string s, find and return the first instance of a non-repeating
	 * character in it. If there is no such character, return '_'.
	 */

	public char firstNotRepeatingCharacter(String s) {
		char[] letters = s.toCharArray();
		char unique = '_';
		for (int i = 0; i < s.length() && unique == '_'; i++) {
			if (s.indexOf(letters[i]) == s.lastIndexOf(letters[i]))
				unique = letters[i];
		}
		return unique;
	}

}
