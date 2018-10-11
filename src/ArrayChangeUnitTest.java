package exploringtwo.the.waters;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayChangeUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] inputArray = { 1, 1, 1 };
		int result = arrayChange(inputArray);
		assertTrue(result == 3);
	}

	int arrayChange(int[] inputArray) {

		int count = 0;

		for (int i = 1; i < inputArray.length; i++) {
			int dif = inputArray[i] - inputArray[i - 1];

			if (dif <= 0) {
				count = count + Math.abs(dif) + 1;
				inputArray[i] = inputArray[i] + Math.abs(dif) + 1;
			}
		}

		return count;
	}
}
