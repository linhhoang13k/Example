package rains.of.reason;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayReplaceUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		int[] inputArray = { 1, 2, 1 };
		int elemToReplace = 1;
		int substitutionElem = 3;

		int[] result = arrayReplace(inputArray, elemToReplace, substitutionElem);

		assertTrue(result[0] == substitutionElem);
		assertTrue(result[2] == substitutionElem);

	}

	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == elemToReplace)
				inputArray[i] = substitutionElem;
		}

		return inputArray;
	}

}
