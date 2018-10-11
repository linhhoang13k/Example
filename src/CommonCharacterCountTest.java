package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.CommonCharacterCount;

public class CommonCharacterCountTest {

	String string1;
	String string2;

	private int countResult() {
		return CommonCharacterCount.commonCharacterCount(string1, string2);
	}

	@Test
	public void shouldMatchSingleCommonCharacterInBothStringsAndReturnCountAs1() {
		string1 = "abcd";
		string2 = "defg";
		assertThat(countResult(), is(1));
	}

	@Test
	public void shouldMatchTwoCommonCharactersInBothStringsAndReturnCountAs2() {
		string1 = "acbc";
		string2 = "cdecf";
		assertThat(countResult(), is(2));
	}

	@Test
	public void shouldMatchThreeCommonCharactersInBothStringsWhenStringHasExtraCommonCharacters() {
		string1 = "aaadddhhh";
		string2 = "adh";
		assertThat(countResult(), is(3));
	}

	@Test
	public void shouldMatchCommonCharactersInBothStringsWhenStringsHaveNoLogicalOrder() {
		string1 = "dehxggyz";
		string2 = "gkadcgfh";
		assertThat(countResult(), is(4));
	}

	@Test
	public void shouldReturnCountNoMatterCharacterCase() {
		string1 = "ABCD";
		string2 = "abcd";
		assertThat(countResult(), is(4));
	}

}
