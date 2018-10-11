package exercise17;

import org.junit.Assert;
import org.junit.Test;

public class ArrayChangeTest {

	@Test
	public void shouldReturn1() {
		ArrayChange underTest = new ArrayChange();
		int[] a = { 1, 1 };
		int moves = underTest.orderedIncrease(a);
		Assert.assertEquals(1, moves);
	}

	@Test
	public void arrayLength3ShouldReturn2() {
		ArrayChange underTest = new ArrayChange();
		int[] a = { -3, 0, -1, 3 };
		int moves = underTest.orderedIncrease(a);
		Assert.assertEquals(2, moves);
	}
	
	@Test
	public void arrayNeedsUpdatedShouldReturn5() {
		ArrayChange underTest = new ArrayChange();
		int[] a = { -3, 0, -1, -1 };
		int moves = underTest.orderedIncrease(a);
		Assert.assertEquals(5, moves);
	}
	
	@Test
	public void arrayWithAlternatingIncreases() {
		ArrayChange underTest = new ArrayChange();
		int[] a = { -3, 0, -4, 10, -20 };
		int moves = underTest.orderedIncrease(a);
		Assert.assertEquals(36, moves);
	}
}
