package com.paigeruppel.interviewpractice.numbertheory;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MissingNumberTest {

	private MissingNumber underTest;

	@Before
	public void setup() {
		underTest = new MissingNumber();
	}

	@Test
	public void shouldReturn2From0ToNEquals3() {
		int[] arr = { 3, 1, 0 };
		assertThat(underTest.findMissingNumber(arr), is(2));
	}

	@Test
	public void shouldReturn1From0ToNEquals1() {
		int[] arr = { 0 };
		assertThat(underTest.findMissingNumber(arr), is(1));
	}

	@Test
	public void shouldReturn0From0ToNEquals2() {
		int[] arr = { 1, 2 };
		assertThat(underTest.findMissingNumber(arr), is(0));
	}
}
