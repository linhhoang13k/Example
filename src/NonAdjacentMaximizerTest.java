package com.paigeruppel.interviewpractice.dynamicprogramming.basic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NonAdjacentMaximizerTest {

    private NonAdjacentMaximizer underTest;

    @Before
    public void setup() {
        underTest = new NonAdjacentMaximizer();
    }

    @Test
    public void arrayOfLength3WithAllOnesShouldReturn2() {
        int[] nums = {1, 1, 1};
        assertThat(underTest.houseRobber(nums), is(2));
    }

    @Test
    public void arrayOfLength0ShouldReturn0() {
        int[] nums = {};
        assertThat(underTest.houseRobber(nums), is(0));
    }

    @Test
    public void arrayWithOnlyAZeroShouldReturn0() {
        int[] nums = {0};
        assertThat(underTest.houseRobber(nums), is(0));
    }

    @Test
    public void arrayWithOnlyAOneShouldReturn1() {
        int[] nums = {1};
        assertThat(underTest.houseRobber(nums), is(1));
    }

    @Test
    public void arrayWithTwoZeroesShouldReturn0() {
        int[] nums = {0, 0};
        assertThat(underTest.houseRobber(nums), is(0));
    }

    @Test
    public void testCase6ShouldReturn2() {
        int[] nums = {2, 1};
        assertThat(underTest.houseRobber(nums), is(2));
    }

    @Test
    public void testCase15ShouldReturn11() {
        int[] nums = {1, 7, 9, 4};
        assertThat(underTest.houseRobber(nums), is(11));
    }

    @Test
    public void testCase29ShouldReturn2069() {
        int[] nums = {127, 188, 240, 241, 164, 137, 123, 78, 118, 84, 210, 242, 87, 214, 237, 206, 183, 210, 81, 171, 66, 80, 109, 65, 76, 109};
        assertThat(underTest.houseRobber(nums), is(2069));
    }

}
