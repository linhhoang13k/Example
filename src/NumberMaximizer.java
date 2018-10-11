package exercise51;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberMaximizer {

	public int deleteDigit(int n) {
		int maxRange = 0;
		List<Integer> digits = buildDigits(n);
		int indexToRemove = 0;
		
		// in each case we are looking to remove the smallest number followed by the largest number
		for (int first = 0, next = 1; next < digits.size(); first++, next++) {
			if (digits.get(next) - digits.get(first) > maxRange) {
				maxRange = digits.get(next) - digits.get(first);
				indexToRemove = first;
			}
		}
		
		if (maxRange == 0) {
			indexToRemove = digits.indexOf(getMinimum(digits));
		}
		
		digits.remove(indexToRemove);
		
		String answer = "";
		
		for (int current : digits) {
			answer += "" + current;
		}
		
		return Integer.parseInt(answer);
	}

	private int getMinimum(List<Integer> digits) {
		Collections.sort(digits);
		return digits.get(0);
	}
	
	private List<Integer> buildDigits(int n) {
		List<Integer> digits = new ArrayList<>();
		int temp = 0;
		while (n > 0) {
			temp = n % 10;
			digits.add(0, temp);
			n = n / 10;
		}
		
		return digits;
	}
}
