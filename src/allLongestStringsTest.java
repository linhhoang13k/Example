package test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.AllLongestStrings;

public class AllLongestStringsTest {

	String[] inputArray;

	private String[] result() {
		return AllLongestStrings.allLongestStrings(inputArray);
	}

	@Test
	public void shouldAddSameLengthStringsToArrayList() {
		inputArray = new String[] { "abc", "cde", "efg" };
		String[] expected = inputArray;
		assertThat(result(), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnLongestStrings() {
		inputArray = new String[] { "abc", "efgh", "fghi", "abcdefg", "cba", "tuvwxyz" };
		String[] expected = { "abcdefg", "tuvwxyz" };
		assertThat(result(), is(equalTo(expected)));
	}

}
