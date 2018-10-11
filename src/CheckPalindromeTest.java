package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.CheckPalindrome;

public class CheckPalindromeTest {

	private String inputString;

	private boolean result() {
		return CheckPalindrome.checkPalindrome(inputString);
	}

	@Test
	public void shouldReturnTrueWhenOneLetterString() {
		inputString = "a";
		assertThat(result(), is(true));
	}

	@Test
	public void shouldReturnFalseWhenInitialLetterDoesNotMatchLastLetter() {
		inputString = "abc";
		assertThat(result(), is(false));
	}

	@Test
	public void shouldReturnFalseWhenInitialTwoLettersDoNotMatchLastTwoLetters() {
		inputString = "abab";
		assertThat(result(), is(false));
	}

	@Test
	public void shouldReturnTrueWhenLongPalindrome() {
		inputString = "abcdefgfedcba";
		assertThat(result(), is(true));
	}

	@Test
	public void shouldReturnTrueNoMatterLetterCaseOfPalindrome() {
		inputString = "AbcDedCBa";
		assertThat(result(), is(true));
	}

}
