package com.paigeruppel.interviewpractice.hashtables;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LexicographSwapTest {

    private LexicographSwap underTest;

    @Before
    public void setup() {
        underTest = new LexicographSwap();
    }

    @Test
    public void testCase1() {
        String str = "abdc";
        int[][] pairs = {{1,4},{3,4}};
        assertThat(underTest.swapLexOrder(str, pairs), is("dbca"));
    }

    @Test
    public void testCase2() {
        String str = "abcdefgh";
        int[][] pairs = {{1,4}, {7,8}};
        assertThat(underTest.swapLexOrder(str, pairs), is("dbcaefhg"));
    }
}
