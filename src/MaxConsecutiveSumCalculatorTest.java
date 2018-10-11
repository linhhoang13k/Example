package exercise37;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MaxConsecutiveSumCalculatorTest {

	private MaxConsecutiveSumCalculator underTest;
	
	@Before
	public void setup() {
		underTest = new MaxConsecutiveSumCalculator();
	}

	@Test
	public void shouldReturn8ForTestCase1() {
		int[] inputArray = {2, 3, 5, 1, 6};
		int k = 2;
		assertThat(underTest.arrayMaxConsecutiveSum(inputArray, k), is(8));
	}
	
	@Test
	public void shouldReturn14ForTestCase2() {
		int[] inputArray = {2, 4, 10, 1};
		int k = 2;
		assertThat(underTest.arrayMaxConsecutiveSum(inputArray, k), is(14));
	}

	@Test
	public void shouldReturnn9ForTestCase3() {
		int[] inputArray = {1, 3, 2, 4};
		int k = 3;
		assertThat(underTest.arrayMaxConsecutiveSum(inputArray, k), is(9));
	}
}
