package exercise18;

import java.util.HashMap;
import java.util.Map;

public class PalindromeRearrange {

	public boolean palindromeRearranging(String test) {
		char[] input = test.toCharArray();
		Map<Integer, Character> searchForPalindrome = new HashMap<>();

		for (int ind = 0; ind < input.length; ind++) {
			char character = input[ind];
			int ascii = (int) character; // sets each character equal to an
											// integer value
			if (!searchForPalindrome.isEmpty() && searchForPalindrome.containsKey(ascii)) {
				searchForPalindrome.remove(ascii);
			} else {
				searchForPalindrome.put(ascii, character); 
			}
		}
		// consider removing any duplicate occurrences of the same key from the map all together
		// that way if the string input is even, the map length should be 0, else if the string input is 0, the map length should be 1
		if (test.length() % 2 == 0 && searchForPalindrome.isEmpty()) { //for even
			return true;
		} else if (test.length() % 2 == 1 && searchForPalindrome.size() == 1) {
			return true;
		}
			return false;
	}

	public int singleOccurrence(String test) {

		char[] input = test.toCharArray();
		Map<Integer, Character> searchForPalindrome = new HashMap<>();
		int count = 0;
		int singleOccurrence = 0;

		for (int ind = 0; ind < input.length; ind++) {
			char character = input[ind];
			int ascii = (int) character; // sets each character equal to an
											// integer value
			if (!searchForPalindrome.isEmpty() && searchForPalindrome.containsKey(ascii)) {
				count++;
			} else {
				searchForPalindrome.put(ascii, character); // puts each
															// value(key)
				singleOccurrence++;
			}
		}
		return singleOccurrence;
	}
}
