package tiendm.codefight.tournament.oct;

import java.util.HashSet;
import java.util.Set;

public class Tour1006 {
	String reflectString(String inputString) {
		String s = "";
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			s += (char) ('a' + 'z' - c) + "";
		}
		return s;
	}

	int divNumber(int k, int l, int r) {

		int ans = 0;
		for (int i = l; i <= r; i++) {
			int n = i;
			int divs = 1;
			for (int j = 2; j * j <= n; j++) {
				int pow = 0;
				while (n % j == 0) {
					n /= j;
					pow++;
				}
				divs *= 1 + pow;
				if (divs > k) {
					break;
				}
			}
			if (n != 1) {
				divs *= 2;
			}
			if (divs == k) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Tour1006 t = new Tour1006();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t);
	}
}
