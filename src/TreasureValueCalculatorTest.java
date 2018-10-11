package exercise39;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreasureValueCalculatorTest {

	private TreasureValueCalculator underTest;
	
	@Before
	public void setup() {
		underTest = new TreasureValueCalculator();
	}
	
	@Test
	public void shouldReturnGreatestValue4GivenValues3And4() {
		assertThat(underTest.findGreatestValue(4, 3), is(4));
	}

	@Test
	public void shouldReturnGreatestValue8GivenValues1And8() {
		assertThat(underTest.findGreatestValue(1, 8), is(8));
	}
	
	@Test
	public void testCase1() {
		int value1 = 10;
		int weight1 = 5;
		int value2 = 6;
		int weight2 = 4;
		int maxW = 8;
		assertThat(underTest.knapsackLight(value1, weight1, value2, weight2, maxW), is(10));
	}
	
	@Test
	public void testCase2() {
		int value1 = 10;
		int weight1 = 5;
		int value2 = 6;
		int weight2 = 4;
		int maxW = 9;
		assertThat(underTest.knapsackLight(value1, weight1, value2, weight2, maxW), is(16));
	}

	@Test
	public void testCase3() {
		int value1 = 5;
		int weight1 = 3;
		int value2 = 7;
		int weight2 = 4;
		int maxW = 6;
		assertThat(underTest.knapsackLight(value1, weight1, value2, weight2, maxW), is(7));
	}
}
 