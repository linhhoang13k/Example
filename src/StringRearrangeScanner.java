package exercise33;

import java.util.ArrayList;

public class StringRearrangeScanner {

	/**
	 * Given an array of equal-length strings, check if it is possible to rearrange
	 * the strings in such a way that after the rearrangement the strings at
	 * consecutive positions would differ by exactly one character.
	 */
	boolean success; // modified by findSequence
	
	boolean stringsRearrangement(String[] inputArray) {		   
	    boolean[] used = new boolean[inputArray.length];
	    findSequence(inputArray, null, used, 0);
	    return success;
	}

	void findSequence(String[] inputArray, String prev, boolean[] used, int n) {
	    if (n == inputArray.length) {
	        success = true;
	        return;
	    }
	    for (int i = 0; i < inputArray.length; i++) {
	        if (!used[i] && (prev == null || differByOne(prev, inputArray[i]))) {
	            used[i] = true;
	            findSequence(inputArray, inputArray[i], used, n+1);
	            used[i] = false;
	        }
	    }
	}

	boolean differByOne(String a, String b) {
		int differences = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				differences++;
			}
		}
		return differences == 1;
	}
}
