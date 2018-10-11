package com.paigeruppel.interviewpractice.strings;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SentenceBuilderTest {
	
	private SentenceBuilder underTest;
	
	@Before
	public void setup() {
		underTest = new SentenceBuilder();
	}
	
	@Test
	public void shouldReturnFormattedStringTestCase1() {
		String s = "CodefightsIsAwesome";
		assertThat(underTest.amendTheSentence(s), is("codefights is awesome"));
	}
	
	@Test
	public void shouldReturnFormattedStringTestCase2() {
		String s = "Hello";
		assertThat(underTest.amendTheSentence(s), is("hello"));
	}
	
	@Test
	public void shouldReturnFormattedStringTestCase3() {
		String s = "vSKwWDjwIerQKMgVaAniorRJlerbKpDgvyKBLPNwSRWtylqKewNFtERNuUBBHAsGkTSSfdhQHJYvAighAdeG";
		assertThat(underTest.amendTheSentence(s), is("v s kw w djw ier q k mg va anior r jlerb kp dgvy k b l p nw s r wtylq kew n ft e r nu u b b h as gk t s sfdh q h j yv aigh ade g"));
	}

}
