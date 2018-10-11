package org.matt.codefights.arcade.intro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdgeOfTheOceanTest {

    EdgeOfTheOcean edgeOfTheOcean;

    @Before
    public void setUp() {
        edgeOfTheOcean = new EdgeOfTheOcean();
    }

    @Test
    public void almostIncreasingSequenceTest1() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 3, 2, 1}));
    }

    @Test
    public void almostIncreasingSequenceTest2() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 3, 2}));
    }

    @Test
    public void almostIncreasingSequenceTest3() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 1, 2}));
    }

    @Test
    public void almostIncreasingSequenceTest4() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 4, 10, 4, 2}));
    }

    @Test
    public void almostIncreasingSequenceTest5() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{10, 1, 2, 3, 4, 5}));
    }

    @Test
    public void almostIncreasingSequenceTest6() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 1, 1, 2, 3}));
    }

    @Test
    public void almostIncreasingSequenceTest7() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{0, -2, 5, 6}));
    }

    @Test
    public void almostIncreasingSequenceTest8() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 3, 4, 5, 3, 5, 6}));
    }

    @Test
    public void almostIncreasingSequenceTest9() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{40, 50, 60, 10, 20, 30}));
    }

    @Test
    public void almostIncreasingSequenceTest10() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 1}));
    }

    @Test
    public void almostIncreasingSequenceTest11() {
        assertEquals(false, edgeOfTheOcean.almostIncreasingSequence(new int[]{10, 1, 2, 3, 4, 5, 6, 1}));
    }

    @Test
    public void almostIncreasingSequenceTest12() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 3, 4, 3, 6}));
    }

    @Test
    public void almostIncreasingSequenceTest13() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 3, 4, 99, 5, 6}));
    }

    @Test
    public void almostIncreasingSequenceTest14() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{123, -17, -5, 1, 2, 3, 12, 43, 45}));
    }

    @Test
    public void almostIncreasingSequenceTest15() {
        assertEquals(true, edgeOfTheOcean.almostIncreasingSequence(new int[]{3, 5, 67, 98, 3}));
    }

}
