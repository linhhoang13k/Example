package exercise20;

import org.junit.Assert;
import org.junit.Test;

public class AdjacentMaxDifferenceTest {

	@Test
	public void shouldReturn5() {
		AdjacentMaxDifference underTest = new AdjacentMaxDifference();
		int[] input = { 10, 15, 12, 13 };
		int difference = underTest.arrayMaximalAdjacentDifference(input);
		Assert.assertEquals(5, difference);
	}

	@Test
	public void shouldReturn5ArrayWithNegatives() {
		AdjacentMaxDifference underTest = new AdjacentMaxDifference();
		int[] input = { -10, -15, -12, -13 };
		int difference = underTest.arrayMaximalAdjacentDifference(input);
		Assert.assertEquals(5, difference);
	}

	@Test
	public void shouldReturn20DifferenceBetweenPosAndNeg() {
		AdjacentMaxDifference underTest = new AdjacentMaxDifference();
		int[] input = { -10, 10, 2, 3 };
		int difference = underTest.arrayMaximalAdjacentDifference(input);
		Assert.assertEquals(20, difference);
	}
}
