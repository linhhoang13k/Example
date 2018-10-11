package com.paigeruppel.interviewpractice.arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharacterTest {

	private UniqueCharacter underTest;
	
	@Before
	public void setup() {
		underTest = new UniqueCharacter();
	}
	
	@Test
	public void shouldReturnCTestCase1() {
		String s = "abacabad";
		assertThat(underTest.firstNotRepeatingCharacter(s), is('c'));
	}
	
	@Test
	public void shouldReturnNoneTestCase2() {
		String s = "abacabaabacaba";
		assertThat(underTest.firstNotRepeatingCharacter(s), is('_'));
	}
	
	@Test
	public void shouldReturnZTestCase3() {
		String s = "z";
		assertThat(underTest.firstNotRepeatingCharacter(s), is('z'));
	}
	
	@Test
	public void shouldReturnCTestCase4() {
		String s = "bcb";
		assertThat(underTest.firstNotRepeatingCharacter(s), is('c'));
	}
}
