package exercise32;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumMinimizerTest {

	@Test
	public void shouldReturnAbsoluteOne() {
		SumMinimizer underTest = new SumMinimizer();
		int response = underTest.getAbsolute(-1);
		assertEquals(response, 1);
	}

	@Test
	public void shouldReturn4() {
		SumMinimizer underTest = new SumMinimizer();
		int[] a = { 2, 4, 7 };
		int response = underTest.absoluteValuesSumMinimization(a);
		assertEquals(4, response);
	}

	@Test
	public void shouldReturn1() {
		SumMinimizer underTest = new SumMinimizer();
		int[] a = { 1, 1, 3, 4 };
		int response = underTest.absoluteValuesSumMinimization(a);
		assertEquals(1, response);
	}
}
