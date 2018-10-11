package exercise31;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class YearToThresholdCalculatorTest {

	private YearToThresholdCalculator underTest;

	@Before
	public void setup() {
		underTest = new YearToThresholdCalculator();
	}

	@Test
	public void shouldReturn20Percent() {
		int rate = 20;
		double response = underTest.rateConvert(rate);
		assertEquals(0.2, response, 0);
	}

	@Test
	public void percentTimesBalanceEqualsTwenty() {
		double response = underTest.calculateProfit(100, 0.20);
		assertEquals(20.0, response, 0);
	}

	@Test
	public void shouldReturn3Years() {
		int deposit = 100;
		int rate = 20;
		int threshold = 170;
		int response = underTest.depositProfit(deposit, rate, threshold);
		assertEquals(3, response);
	}
}
