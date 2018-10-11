package rains.of.reason;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlphabeticShiftUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String inputString = "crazy";

		String result = alphabeticShift(inputString);

		assertTrue("dsbaz".equals(result));
	}

	String alphabeticShift(String inputString) {

		String result = "";

		for (char c : inputString.toCharArray()) {
			char newLetter = (char) (((c - 'a' + 1) % 26) + 'a');

			result = result + Character.toString(newLetter);
		}

		System.out.println(result);

		return result;
	}
}
