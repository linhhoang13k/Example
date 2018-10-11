package exercise53;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClockTest {

	private Clock underTest;
	
	@Before
	public void setup() {
		underTest = new Clock();
	}
	
	@Test
	public void shouldReturnTrueFor1358() {
		assertTrue(underTest.isValidTime("13:58"));
	}
	
	@Test
	public void shouldReturnFalseFor2551() {
		assertFalse(underTest.isValidTime("25:51"));
	}

	@Test
	public void shouldReturnFalseFor0276() {
		assertFalse(underTest.isValidTime("02:76"));
	}
	
	@Test
	public void shouldReturnFalseFor2416() {
		assertFalse(underTest.isValidTime("24:16"));
	}
}
