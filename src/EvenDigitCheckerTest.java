package exercise26;

import org.junit.Assert;
import org.junit.Test;

public class EvenDigitCheckerTest {

	@Test
	public void shouldReturnTrue() {
		EvenDigitChecker underTest = new EvenDigitChecker();
		boolean response = underTest.evenDigitsOnly(846);
		Assert.assertEquals(true, response);
	}
	
	@Test
	public void shouldReturnFalse() {
		EvenDigitChecker underTest = new EvenDigitChecker();
		boolean response = underTest.evenDigitsOnly(836);
		Assert.assertEquals(false, response);
	}
}
