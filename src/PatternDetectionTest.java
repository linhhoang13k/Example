package com.paigeruppel.interviewpractice.strings;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PatternDetectionTest {

	
	private PatternDetection underTest;
	
	@Before
	public void setup() {
		underTest = new PatternDetection();
	}
	
	@Test
	public void testCase1() {
		String s = "CodefightsIsAwesome";
		String x = "IA";
		assertThat(underTest.findFirstSubstringOccurrence(s, x), is(-1));
	}
	
	@Test
	public void testCase2() {
		String s = "CodefightsIsAwesome";
		String x = "IsA";
		assertThat(underTest.findFirstSubstringOccurrence(s, x), is(10));
	}
	
	@Test
	public void testCase3() {
		String s = "a";
		String x = "a";
		assertThat(underTest.findFirstSubstringOccurrence(s, x), is(0));
	}
}
