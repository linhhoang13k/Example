package exercise25;

import org.junit.Assert;
import org.junit.Test;

public class ArrayReplacerTest {

	@Test
	public void shouldReturn323() {
		ArrayReplacer underTest = new ArrayReplacer();
		int[] inputArray = { 1, 2, 1 };
		int elemToReplace = 1;
		int substitutionElem = 3;
		int[] response = underTest.arrayReplace(inputArray, elemToReplace, substitutionElem);
		int[] expectedAnswer = {3, 2, 3};
		Assert.assertArrayEquals(expectedAnswer, response);
	}
	
	@Test
	public void testCase2FromCodeFights() {
		ArrayReplacer underTest = new ArrayReplacer();
		int[] inputArray = { 1, 2, 3, 4, 5 };
		int elemToReplace = 3;
		int substitutionElem = 0;
		int[] response = underTest.arrayReplace(inputArray, elemToReplace, substitutionElem);
		int[] expectedAnswer = {1, 2, 0, 4, 5};
		Assert.assertArrayEquals(expectedAnswer, response);
	}
}
