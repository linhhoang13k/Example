package exercise54;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RatiorgTest {

	private Ratiorg underTest;

	@Before
	public void setup() {
		underTest = new Ratiorg();
	}

	@Test
	public void shouldReturn14() {
		assertThat(underTest.sumUpNumbers("2 apples, 12 oranges"), is(14));
	}

	@Test
	public void shouldReturn123450FromIdenticalString() {
		assertThat(underTest.sumUpNumbers("123450"), is(123450));
	}
	
	@Test
	public void shouldReturn0FromStringWithNoDigits() {
		assertThat(underTest.sumUpNumbers("Your payment method is invalid"), is(0));
	}
	
}
