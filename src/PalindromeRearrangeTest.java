package exercise18;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeRearrangeTest {

	@Test
	public void shouldReturnSingleOccurrence2() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "aabb";
		int singles = underTest.singleOccurrence(test);
		Assert.assertEquals(2, singles);
	}
	
	
	@Test
	public void palindromeEvenLengthShouldReturnTrue() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "aabb";
		boolean answer = underTest.palindromeRearranging(test);
		Assert.assertEquals(true, answer);
	}
	
	@Test 
	public void palindromeEvenLengthShouldReturnFalse() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "aacb";
		boolean answer = underTest.palindromeRearranging(test);
		Assert.assertEquals(false, answer);
	}
	
	@Test
	public void palindromeOddLengthShouldReturnTrue() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "aacbb";
		boolean answer = underTest.palindromeRearranging(test);
		Assert.assertEquals(true, answer);
	}
	
	@Test
	public void palindromeZaaOddLengthShouldReturnTrue() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "zaa";
		boolean answer = underTest.palindromeRearranging(test);
		Assert.assertEquals(true, answer);
	}
	
	@Test
	public void palindromeOddLengthShouldReturnFalse() {
		PalindromeRearrange underTest = new PalindromeRearrange();
		String test = "aaceb";
		boolean answer = underTest.palindromeRearranging(test);
		Assert.assertEquals(false, answer);
	}
}
