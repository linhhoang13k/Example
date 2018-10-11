package com.paigeruppel.codefights.challenges;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExponentComparisonTest {

    private ExponentComparison underTest;

    @Before
    public void setup() {
        underTest = new ExponentComparison();
    }

    @Test
    public void shouldReturn1AIsGreaterThanBTestCase1() {
        int[] m = {2, 5, 2, 5, 5, 2, 5, 2};
        assertThat(underTest.compare2Power(m), is(1));
    }

    @Test
    public void shouldReturn0AEqualsBTestCase2() {
        int[] m = {2, 3, 4, 5, 2, 3, 4, 5};
        assertThat(underTest.compare2Power(m), is(0));
    }

    @Test
    public void shouldReturn1AIsGreaterThanBTestCase3() {
        int[] m = {3, 3, 7, 6, 5, 6, 7, 4};
        assertThat(underTest.compare2Power(m), is(1));
    }

    @Test
    public void shouldReturnNeg1BIsGreaterThanATestCase4() {
        int[] m ={3, 2, 5, 6, 5, 3, 7, 5};
        assertThat(underTest.compare2Power(m), is(-1));
    }

    @Test
    public void shouldReturnNeg1BIsGreaterThanATestCase5() {
        int[] m ={10, 17, 13, 16, 9, 8, 15, 17};
        assertThat(underTest.compare2Power(m),is(-1));
    }
}
