package exercise33;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringRearrangeScannerTest {

	private StringRearrangeScanner underTest;

	@Before
	public void setup() {
		underTest = new StringRearrangeScanner();
	}

	@Test
	public void shouldReturnCatAndBatAreOffByOneChar() {
		String a = "cat";
		String b = "bat";

		assertThat(underTest.differByOne(a, b), is(true));
	}

	@Test
	public void shouldReturnCatAndDogAreNotOffByOneChar() {
		String a = "cat";
		String b = "dog";

		assertThat(underTest.differByOne(a, b), is(false));
	}

	@Test
	public void shouldReturnFalseTestCase1() {
		String[] inputArray = { "aba", "bbb", "bab" };
		boolean response = underTest.stringsRearrangement(inputArray);
		assertEquals(false, response);
	}

	@Test
	public void shouldReturnTrueTestCase2() {
		String[] inputArray = { "ab", "bb", "aa" };
		assertThat(underTest.stringsRearrangement(inputArray), is(true));
	}

	@Test
	public void matchingSingleCharsShouldReturnFalseTestCase3() {
		String[] inputArray = { "q", "q", "q" };
		assertThat(underTest.stringsRearrangement(inputArray), is(false));
	}

	@Test
	public void shouldReturnTrueTestCase4() {
		String[] inputArray = { "zzzzab", "zzzzbb", "zzzzaa" };
		assertThat(underTest.stringsRearrangement(inputArray), is(true));
	}

	@Test
	public void shouldReturnFalseTestCase5() {
		String[] inputArray = { "ab", "ad", "ef", "eg" };
		assertThat(underTest.stringsRearrangement(inputArray), is(false));
	}

	@Test
	public void shouldReturnTrueTestCase6() {
		String[] inputArray = { "abc", "bef", "bcc", "bec", "bbc", "bdc" };
		assertThat(underTest.stringsRearrangement(inputArray), is(true));
	}

	@Test
	public void shouldReturnFalseWithTwoIdenticalStringsTestCase7() {
		String[] inputArray = { "abc", "abx", "axx", "abc" };
		assertThat(underTest.stringsRearrangement(inputArray), is(false));
	}

	@Test
	public void shouldReturnTrueTestCase8() {
		String[] inputArray = { "abc", "abx", "axx", "abx", "abc" };
		assertThat(underTest.stringsRearrangement(inputArray), is (true));
	}

	// equal number of strings and two pairs of duplicates
	@Test
	public void shouldReturnFalseExtendedTestCase() {
		String[] inputArray = { "abc", "xbc", "xxc", "xbc", "aby", "ayy", "aby", "azc" };
		assertThat(underTest.stringsRearrangement(inputArray), is(false));
	}

	@Test
	public void shouldReturnTrueExtendedTestCase() {
		String[] inputArray = { "abc", "bef", "bcc", "bew", "zew", "zyw", "bec", "bbc", "bdc" };
		assertThat(underTest.stringsRearrangement(inputArray), is(true));
	}
}
