package exercise54;

public class Ratiorg {
	/*
	 * CodeMaster has just returned from shopping. He scanned the check of the items
	 * he bought and gave the resulting string to Ratiorg to figure out the total
	 * number of purchased items. Since Ratiorg is a bot he is definitely going to
	 * automate it, so he needs a program that sums up all the numbers which appear
	 * in the given input.
	 * 
	 * Help Ratiorg by writing a function that returns the sum of numbers that
	 * appear in the given inputString.
	 */

	public int sumUpNumbers(String inputString) {
		String[] parts = inputString.split("\\D");
		Integer sum = 0;
		for (int i = 0; i < parts.length; i++) {
			Integer index = tryParse(parts[i]);
			sum += index;
		}
		return sum;
	}

	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
