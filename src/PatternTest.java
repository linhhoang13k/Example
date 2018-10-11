package com.paigeruppel.interviewpractice.hashtables;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PatternTest {

	private Pattern underTest;

	@Before
	public void setup() {
		underTest = new Pattern();
	}

	@Test
	public void shouldReturnTrueTestCase1() {
		String[] strings = { "cat", "dog", "dog" };
		String[] patterns = { "a", "b", "b" };
		assertTrue(underTest.areFollowingPatterns(strings, patterns));
	}

	@Test
	public void shouldReturnFalseTestCase2() {
		String[] strings = { "cat", "dog", "doggy" };
		String[] patterns = { "a", "b", "b" };
		assertFalse(underTest.areFollowingPatterns(strings, patterns));
	}
	
	@Test
	public void shouldReturnFalseTestCase3() {
		String[] strings = { "cat", "dog", "dog" };
		String[] patterns = { "a", "b", "c" };
		assertFalse(underTest.areFollowingPatterns(strings, patterns));
	}
	
	
}
