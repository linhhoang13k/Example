package com.paigeruppel.interviewpractice.hashtables;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndexComparisonTest {

	private IndexComparison underTest;

	@Before
	public void setup() {
		underTest = new IndexComparison();
	}

	@Test
	public void shouldReturnTrueTestCase1() {
		int[] nums = { 0, 1, 2, 3, 5, 2 };
		int k = 3;
		assertTrue(underTest.containsCloseNums(nums, k));
	}

	@Test
	public void shouldReturnFalseTestCase2() {
		int[] nums = { 0, 1, 2, 3, 5, 2 };
		int k = 2;
		assertFalse(underTest.containsCloseNums(nums, k));
	}

	@Test
	public void shouldReturnFalseTestCase3() {
		int[] nums = {};
		int k = 0;
		assertFalse(underTest.containsCloseNums(nums, k));
	}

	@Test
	public void shouldReturnTrueTestCase4() {
		int[] nums = { 99, 99 };
		int k = 2;
		assertTrue(underTest.containsCloseNums(nums, k));
	}

}
