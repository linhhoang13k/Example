package exercise35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitDetector {

	// return the leftmost digit that occurs in a given string
	public char firstDigit(String inputString) {
		char[] input = inputString.toCharArray();
		char firstDigit = ' ';
		for (int i = 0; i < input.length; i++) {
			if (digitsList.contains(input[i])) {
				firstDigit = input[i];
				break;
			}
		}
		return firstDigit;
	}

	List<Character> digitsList = new ArrayList<>(Arrays.asList( '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
}
