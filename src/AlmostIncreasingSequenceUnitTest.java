package edge.of.the.ocean.phase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlmostIncreasingSequenceUnitTest {

	private int[] sequence;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test2() {
		sequence = new int[] { 1, 3, 2 };

		boolean result = almostIncreasingSequence(sequence);

		assertTrue(result);
	}

	@Test
	public void test3() {
		sequence = new int[] { 1, 2, 1, 2 };



		boolean result = almostIncreasingSequence(sequence);

		assertFalse(result);
	}


	@Test
	public void test5() {
		sequence = new int[] { 10, 1, 2, 3, 4, 5 };

		boolean result = almostIncreasingSequence(sequence);



		assertTrue(result);
	}

	@Test
	public void test6() {
		sequence = new int[] { 1, 1, 1, 2, 3 };

		boolean result = almostIncreasingSequence(sequence);

		assertFalse(result);
	}

	boolean almostIncreasingSequence(int[] sequence) {
		boolean noFailuresYet = true;
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] >= sequence[i + 1]) {
				if (noFailuresYet) {
					if (i != 0 && i != sequence.length - 2) {
						if (sequence[i + 1] <= sequence[i - 1]) {
							// Here we run the next iteration of the loop
							// manually
							// Alternatively we could set sequence[i] =
							// sequence[i-1]
							// but I don't want to modify the input array
							// in case this function were to get used to check
							// something elsewhere
							if (sequence[i + 2] <= sequence[i]) {
								return false;
							}
							i++;
						}
					}
					noFailuresYet = false;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	boolean almostIncreasingSequence2(int[] sequence) {
		int increasingCount = findDecreasingElement(sequence);
		if (increasingCount == sequence.length) {
			// the whole sequence is increasing
			return true;
		}

		if (sequence[increasingCount - 2] < sequence[increasingCount]) {
			// the element at increasingCount - 1 is exceptionally big, so
			// remove that
			return findDecreasingElement(sequence, increasingCount) == sequence.length;
		}

		if (sequence[increasingCount - 1] < sequence[increasingCount + 1]) {
			// The element at increasingCount is exceptionally small, so remove
			// it
			return findDecreasingElement(sequence, increasingCount + 1) == sequence.length;
		}

		// neither removing at increasingCount - 1 nor increasingCount helps
		return false;
	}

	public static int findDecreasingElement(int[] sequence) {
		return findDecreasingElement(sequence, 0);
	}

	public static int findDecreasingElement(int[] sequence, int start) {
		for (int i = start + 1; i < sequence.length; i++) {
			if (sequence[i - 1] >= sequence[i]) {
				return i;
			}
		}

		// if there are no decreasing elements, return the index of the end
		return sequence.length;
	}

}
