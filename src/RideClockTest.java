package exercise7;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RideClockTest {

	private RideClock underTest;

	@Before
	public void setup() {
		underTest = new RideClock();
	}

	@Test
	public void shouldReturn4TestCase1() {
		int n = 240; // n is time in minutes
		int sumConverted = 4; // sumConverted = minutes changed to HH:MM format --> sum of those digits
		assertThat(underTest.lateRide(n), is(sumConverted));
	}
	
	@Test
	public void shouldReturn14TestCase2() {
		int n = 808;
		int sumConverted = 14;
		assertThat(underTest.lateRide(n), is(sumConverted));
	}

	@Test
	public void shouldReturn19TestCase3() {
		int n = 1439;
		int sumConverted = 19;
		assertThat(underTest.lateRide(n), is(sumConverted));
	}
	
	@Test
	public void shouldReturn0TestCase4() {
		int n = 0;
		int sumConverted = 0;
		assertThat(underTest.lateRide(n), is(sumConverted));
	}

}
