package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.IsLucky;

public class IsLuckyTest {

	int ticketNumber;

	private boolean result() {
		return IsLucky.isLucky(ticketNumber);
	}

	@Test
	public void shouldReturnTrueWhenFirstNumberEqualsSecondNumberInTwoDigitNumber() {
		ticketNumber = 33;
		assertThat(result(), is(true));
	}

	@Test
	public void shouldReturnFalseWhenFirstNumberDoesNotEqualSecondNumberInTwoDigitNumber() {
		ticketNumber = 54;
		assertThat(result(), is(false));
	}

	@Test
	public void shouldReturnTrueWhenFirstHalfOfNumberEqualsSecondHalfInFourDigitNumber() {
		ticketNumber = 1524;
		assertThat(result(), is(true));
	}

	@Test
	public void shouldReturnTrueWhenFirstHalfOfNumberEqualsSecondHalfInSixDigitNumber() {
		ticketNumber = 234162;
		assertThat(result(), is(true));

	}

	@Test
	public void shouldReturnFalseWhenTicketHasOddNumberOfDigits() {
		ticketNumber = 23432;
		assertThat(result(), is(false));
		}

}
