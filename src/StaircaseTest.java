package com.paigeruppel.interviewpractice.dynamicprogramming.basic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StaircaseTest {

	private Staircase underTest;
	
	@Before
	public void setup() {
		underTest = new Staircase();
	}

	@Test
	public void climbingStairsWith1StepShouldReturn1Combination() {
		assertThat(underTest.climbingStairs(1), is(1));
	}
	
	@Test
	public void climbingStairsWith2StepsShouldReturn2Combinations() {
		assertThat(underTest.climbingStairs(2), is(2));
	}
	
	@Test
	public void climbingStairsWith4StepsShouldReturn5Combinations() {
		assertThat(underTest.climbingStairs(4), is(5));
	}

	@Test
	public void climbingStairsWith13StepsShouldReutrn377Combinations() {
		assertThat(underTest.climbingStairs(13), is(377));
	}
	
	@Test
	public void climbingStairsWith26StepsShouldReturn196418Combinations() {
		assertThat(underTest.climbingStairs(26), is(196418));
	}
	
}
