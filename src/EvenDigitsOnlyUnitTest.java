package rains.of.reason;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class EvenDigitsOnlyUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test2() {
		int n = 642386;

		boolean result = evenDigitsOnly(n);

		assertFalse(result);
	}

	boolean evenDigitsOnly(int n) {

		String nAsString = Integer.toString(n);

		for (int i = 0; i < nAsString.length(); i++) {
			int digit = Character.digit(nAsString.charAt(i), 10);

			if ((digit % 2) != 0)
				return false;
		}

		return true;

	}
}
