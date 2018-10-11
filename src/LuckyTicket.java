package codefights;

import java.util.ArrayList;

public class LuckyTicket {
//	 looks at an integer input - determines if the first half of the int's digits sum
// and the second half of the int's digits sum are equal
	boolean isLucky(int n) {

		ArrayList<Integer> digits = new ArrayList<Integer>();

		while (n > 0) {
			digits.add(n % 10);
			n = n / 10;
		}

		int length = digits.size();
		int half = length / 2;
		int sum1 = 0;
		int sum2 = 0;
		// iterate over the first half of the digits (really second half since
		// we popped them off of the int in reverse order
		for (int index1 = 0; index1 < half; index1++) {
			sum1 = sum1 + digits.get(index1);
		}
		
		// do the same thing for the second (really first) half
		// index2 gets set to one less than half (since index is one less than that value)
		for (int index2 = half--; index2 < length; index2++) {
			sum2 = sum2 + digits.get(index2);
		}

		if (sum1 == sum2) {
			return true;
		} else
			return false;
	}
}
