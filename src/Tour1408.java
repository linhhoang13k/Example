package tiendm.codefight.tournament.aug;

import java.util.Arrays;

public class Tour1408 {
	int numberOfOperations(int a, int b) {
		int min = Math.min(a, b), max = Math.max(a, b);
		int count = 0;
		while (max % min == 0 && min > 1) {
			count++;
			int t = min;
			min = max / min;
			max = t;
			if (min > max) {
				int tmp = max;
				max = min;
				min = tmp;
			}
		}
		return count;
	}

	char lastDigitRegExp(String inputString) {
		for (int i = inputString.length() - 1; i >= 0; i--) {
			if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
				return inputString.charAt(i);
			}
		}
		return ' ';
	}

	String replaceFirstDigitRegExp(String input) {
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				return input.replace(input.charAt(i), '#');
			}
		}
		return input;
	}

	boolean equationTemplate(int[] input) {
		Arrays.sort(input);
		return input[0] * input[1] * input[2] == input[3] || input[0] * input[3] == input[1] * input[2]
				|| input[0] * input[1] == input[2] * input[3] || input[0] == input[1] * input[2] * input[3]
				|| input[0] * input[2] == input[1] * input[3];

	}

	public static void main(String[] args) {
		Tour1408 t = new Tour1408();
		System.out.println(t.numberOfOperations(432, 72));
	}
}
