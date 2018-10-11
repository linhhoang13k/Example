package com.paigeruppel.codefights.challenges;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class NthSmallestIntegerTest {
    private NthSmallestInteger underTest;

    @Before
    public void setup() {
        underTest = new NthSmallestInteger();
    }

    @Test
    public void shouldReturn12FromNEquals7() {
        int n = 7;
        int[] a = {3, 5, 7};
        int result = underTest.findNthSmallestMultiple(a, n);
        assertThat(result, is(12));
    }

    @Test
    public void shouldReturn8FromNEquals4() {
        int n = 4;
        int[] a = {4, 10, 2};
        assertThat(underTest.findNthSmallestMultiple(a, n), is(8));
    }
}
