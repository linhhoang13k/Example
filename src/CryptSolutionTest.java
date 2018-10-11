package com.ab.cf.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ab.cf.array.CryptSolution;

public class CryptSolutionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsCryptSolution() {

		String[] crypt = { "SEND", "MORE", "MONEY" };

		char[][] solution = { { 'O', '0' }, { 'M', '1' }, { 'Y', '2' }, { 'E', '5' }, { 'N', '6' }, { 'D', '7' },
				{ 'R', '8' }, { 'S', '9' } };

		CryptSolution cs = new CryptSolution();
		Assert.assertTrue(cs.isCryptSolution(crypt, solution));

	}

	@Test
	public void testIsCryptSolutionAAA() {

		String[] crypt = { "A", "A", "A" };

		char[][] solution = { { 'A', '0' } };

		CryptSolution cs = new CryptSolution();
		Assert.assertTrue(cs.isCryptSolution(crypt, solution));

	}

	@Test
	public void testIsCryptSolution19() {

		String[] crypt = { "WASD", "IJKL", "AOPAS" };

		char[][] solution = { { 'W', '2' }, { 'A', '0' }, { 'S', '4' }, { 'D', '1' }, { 'I', '5' }, { 'J', '8' },
				{ 'K', '6' }, { 'L', '3' }, { 'O', '7' }, { 'P', '9' } };

		CryptSolution cs = new CryptSolution();
		Assert.assertTrue(cs.isCryptSolution(crypt, solution));

	}

	@Test
	public void testCharArrayToString() {

		char[] s = { '2', '5', '6', '7' };

		Assert.assertEquals("2567", new String(s));
		Assert.assertEquals(2567, Integer.parseInt(new String(s)));

	}

}
