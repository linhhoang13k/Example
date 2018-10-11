package exploringtwo.the.waters;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlternatingSumsUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] a = { 50, 60, 60, 45, 70 };

		int teamOneSum = 0;
		int teamTwoSum = 0;

		for (int i = 0; i < a.length; i++) {

			if (i % 2 == 0) {
				teamOneSum += a[i];
			} else {
				teamTwoSum += a[i];
			}
		}

		int[] result = { teamOneSum, teamTwoSum };

		assertTrue(result[0] == 180);
		assertTrue(result[1] == 105);
	}

	int[] alternatingSums(int[] a) {

		return null;
	}
}
