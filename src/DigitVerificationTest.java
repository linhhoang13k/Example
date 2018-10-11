package exercise48;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DigitVerificationTest {

	private DigitVerification underTest;
	
	@Before
	public void setup() {
		underTest = new DigitVerification();
	}
	
	@Test
	public void shouldReturnTrueForZero() {
		assertTrue(underTest.isDigit('0'));
	}
	
	@Test
	public void shouldReturnFalseForHyphen() {
		assertFalse(underTest.isDigit('-'));
	}

	@Test
	public void shouldReturnFalseForO() {
		assertFalse(underTest.isDigit('O'));
	}	

}
