package smooth.saling;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IsLuckyUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		int n = 1230;
		boolean result = isLucky(n);
		assertTrue(result);
	}

	boolean isLucky(int n) {

		String nAsString = String.valueOf(n);

		int midleIndex = nAsString.length() / 2;
		String leftNAsString = nAsString.substring(0, midleIndex);
		String rightNAsString = nAsString.substring(midleIndex, nAsString.length());

		System.out.println(leftNAsString + "   " + rightNAsString);

		Integer leftSum = sum(leftNAsString);
		Integer rightSum = sum(rightNAsString);

		return leftSum.equals(rightSum);
	}

	Integer sum(String digits) {

		Integer digitsSum = 0;

		for (int i = 0; i < digits.length(); i++) {
			int digit = Character.digit(digits.charAt(i), 10);

			digitsSum = digitsSum + digit;
		}

		return digitsSum;
	}

}
