package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.AdjacentElementsProduct;

public class AdjacentElementsProductTest {

	@Test
	public void shouldMultiplyElementThreeByRightElementAndReassignProductAs36() {
		int[] inputArray = { 5, 7, -3, 9, 4, -7 };
		int result = AdjacentElementsProduct.adjacentElementsProduct(inputArray);
		assertThat(result, is(36));
	}

}
