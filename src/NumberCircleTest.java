package exercise6;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumberCircleTest {

	private NumberCircle underTest;
	
	@Before
	public void setup() {
		underTest = new NumberCircle();
	}
	
	@Test
	public void shouldReturn7TestCase1() {
		int n = 10;
		int firstNumber = 2;
		assertThat(underTest.circleOfNumbers(n, firstNumber), is(7));
	}
	
	@Test
	public void shouldReturn2TestCase2() {
		int n = 10;
		int firstNumber = 7;
		assertThat(underTest.circleOfNumbers(n, firstNumber), is(2));
	}

	@Test
	public void shouldReturn3TestCase3() {
		int n = 4;
		int firstNumber = 1;
		assertThat(underTest.circleOfNumbers(n, firstNumber), is(3));
	}

	@Test
	public void shouldReturn0TestCase4() {
		int n = 6;
		int firstNumber = 3;
		assertThat(underTest.circleOfNumbers(n, firstNumber), is(0));
	}
}
