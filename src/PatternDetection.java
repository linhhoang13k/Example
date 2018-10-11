package com.paigeruppel.interviewpractice.strings;

public class PatternDetection {

	public int findFirstSubstringOccurrence(String s, String x) {
		int sL = s.length();
		int xL = x.length();
		for (int i = 0; i <= sL - xL; i++) {
			if (s.charAt(i) == x.charAt(0) && s.charAt(i + xL - 1) == x.charAt(xL - 1)) {
				if (s.substring(i, i+xL).equals(x)) {
					return i;
				}
			}
		}
		return -1;
	}

}
