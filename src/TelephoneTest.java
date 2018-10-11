package com.paigeruppel.interviewpractice.counting;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TelephoneTest {

	private Telephone underTest;

	@Before
	public void setup() {
		underTest = new Telephone();
	}

	@Test
	public void pressingButtons42ShouldReturnArrayWith9Combinations() {
		String buttons = "42";
		String[] messages = { "ga", "gb", "gc", "ha", "hb", "hc", "ia", "ib", "ic" };
		assertThat(underTest.pressingButtons(buttons), is(messages));
	}

	@Test
	public void pressingButton2ShouldReturnArrayWith3Combinations() {
		String buttons = "2";
		String[] messages = { "a", "b", "c" };
		assertThat(underTest.pressingButtons(buttons), is(messages));
	}
	
	@Test
	public void pressingButton3ShouldReturnArrayWith3Combinations() {
		String buttons = "3";
		String[] messages = { "d", "e", "f" };
		assertThat(underTest.pressingButtons(buttons), is(messages));
	}

}
