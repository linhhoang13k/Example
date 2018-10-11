package exercise51;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumberMaximizerTest {

	private NumberMaximizer underTest;
	
	@Before
	public void setup() {
		underTest = new NumberMaximizer();
	}
	
	@Test
	public void shouldReturn52From152() {
		assertThat(underTest.deleteDigit(152), is(52));
	}

	@Test
	public void shouldReturn101From1001() {
		assertThat(underTest.deleteDigit(1001), is(101));
	}
	
	@Test
	public void shouldReturn1From10() {
		assertThat(underTest.deleteDigit(10), is(1));
	}
	
	@Test
	public void shouldReturn22229From222219() {
		assertThat(underTest.deleteDigit(222219), is(22229));
	}
	
	@Test
	public void shouldReturn11From110() {
		assertThat(underTest.deleteDigit(110), is(11));
	}
}
