package exercise16;

import org.junit.Test;

import org.junit.Assert;

public class SwappingPairsTest {

	@Test	
	public void differencesShouldEqual2() {
		// arrange
		SwappingPairs underTest = new SwappingPairs();
		int[] a = {2, 5, 8};
		int[] b = {2, 6, 7};
		// act
		int response =underTest.differences(a, b);
		// assert
		Assert.assertEquals(2, response);
	}
	
	@Test
	public void swappedPairsEquals1() {
		SwappingPairs underTest = new SwappingPairs();
		int[] a = {2, 5, 8, 9};
		int[] b = {5, 2, 8, 9};
		int numberSwapped = underTest.swapped(a, b);
		Assert.assertEquals(1, numberSwapped);
	}
	
	@Test 
	public void swappedPairsMaxIndex() {
		SwappingPairs underTest = new SwappingPairs();
		int[] a = {5, 5, 9, 8};
		int[] b = {5, 5, 8, 9};
		int numberSwapped = underTest.swapped(a, b);
		Assert.assertEquals(1, numberSwapped);
	}
	
	@Test
	public void swappedAndDifferencesEquals2() {
		SwappingPairs underTest = new SwappingPairs();
		int[] a = {2, 5, 8, 9};
		int[] b = {5, 2, 8, 9};
		int numberChanged = underTest.swapAndDifferences(a, b);
		Assert.assertEquals(1, numberChanged);
	}
}
