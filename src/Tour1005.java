package tiendm.codefight.tournament.oct;

import java.util.HashSet;
import java.util.Set;

public class Tour1005 {
	int depositProfit(int deposit, int rate, int threshold) {
		double grow = 1 + rate / 100.0;
		int year = (int) (Math.log((double) threshold / deposit) / Math.log(grow));
		if (deposit * Math.pow(grow, year) < threshold) {
			year++;
		}
		return year;
	}

	String integerToStringOfFixedWidth(int number, int width) {
		String s = number + "";
		int L = s.length();
		if (L == width) {
			return s;
		} else if (L < width) {
			for (int i = 0; i < width - L; i++) {
				s = "0" + s;
			}
			return s;
		}
		return s.substring(L - width);
	}

	int digitDistanceNumber(int n) {
		int result = 0;
		int lastDigit = n % 10;
		int tenPower = 1;
		n /= 10;
		while (n != 0) {
			result += Math.abs(n % 10 - lastDigit) * tenPower;
			tenPower *= 10;
			lastDigit = n % 10;
			n /= 10;
		}

		return result;
	}

	int differentSubstringsTrie(String inputString) {
		Set<String> s = new HashSet<>();
		for (int i = 1; i <= inputString.length(); i++) {
			for (int j = 0; j <= inputString.length() - i; j++) {
				s.add(inputString.substring(j, j + i));
			}
		}
		return s.size();
	}

	int sumBelowBound(int bound) {

		int left = 0, right = bound + 1;
		while (right - left > 1) {
			int middle = (left + right) / 2;
			if (middle * (middle + 1) / 2 <= bound) {
				left = middle;
			} else {
				right = middle;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		Tour1005 t = new Tour1005();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t.differentSubstringsTrie("abac"));
	}
}
