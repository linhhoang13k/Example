package island.of.knowledge;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayMaximalAdjacentDifferenceUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		int[] inputArray = { 2, 4, 1, 0 };
		int result = arrayMaximalAdjacentDifference(inputArray);
		assertTrue(result == 3);
	}

	int arrayMaximalAdjacentDifference(int[] inputArray) {

		int maxDifference = 0;

		for (int i = 1; i < inputArray.length - 1; i++) {
			int leftDifference = Math.abs(inputArray[i - 1] - inputArray[i]);
			int rightDifference = Math.abs(inputArray[i] - inputArray[i + 1]);

			if (leftDifference > rightDifference) {
				if (leftDifference > maxDifference)
					maxDifference = leftDifference;
			} else if (rightDifference > maxDifference)
				maxDifference = rightDifference;
		}

		return maxDifference;
	}

}
