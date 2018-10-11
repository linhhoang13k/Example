package exercise8;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PayPhoneTest {

	private PayPhone underTest;

	@Before
	public void setup() {
		underTest = new PayPhone();
	}

	@Test
	public void shouldReturn14TestCase1() {
		int min1 = 3;
		int min2_10 = 1;
		int min11 = 2;
		int s = 20;
		assertThat(underTest.phoneCall(min1, min2_10, min11, s), is(14));
	}
	
	@Test
	public void shouldReturn2TestCase2() {
		int min1 = 2;
		int min2_10 = 2;
		int min11 = 1;
		int s = 2;
		assertThat(underTest.phoneCall(min1, min2_10, min11, s), is(1));
	}
	
	@Test
	public void shouldReturn11TestCase3() {
		int min1 = 10;
		int min2_10 = 1;
		int min11 = 2;
		int s = 22;
		assertThat(underTest.phoneCall(min1, min2_10, min11, s), is(11));
	}
}
