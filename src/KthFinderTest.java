package com.paigeruppel.heapsstacksqueues;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class KthFinderTest {

	private KthFinder underTest;
	
	@Before
	public void setup() {
		underTest = new KthFinder();
	}
	
	@Test
	public void secondLargestElementShouldReturnSixTestCase1() {
		int[] nums = { 7,6,5,4,3,2,1};
		int k =2;
		assertThat(underTest.kthLargestElement(nums, k), is(6));
	}
	
	@Test
	public void firstLargestElementShouldReturn99FromArrayWithTwoIdenticalNumbersTestCase2() {
		int[] nums = {99,99};
		int k = 1;
		assertThat(underTest.kthLargestElement(nums, k), is(99));
	}
	
	@Test
	public void secondLargestElementShouldReturn0FromArrayWithNegativeNumberTestCase5() {
		int[] nums = {-1, 2, 0};
		int k = 2;
		assertThat(underTest.kthLargestElement(nums, k), is(0));
	}
}
