package com.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstDuplicateTest {

    @Test
    public void test1() throws Exception {
        assertEquals(3, FirstDuplicate.firstDuplicate(new int[]{2, 3, 3, 1, 5, 2}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(-1, FirstDuplicate.firstDuplicate(new int[]{2, 4, 3, 5, 1}));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(-1, FirstDuplicate.firstDuplicate(new int[]{1}));
    }

    @Test
    public void test4() throws Exception {
        assertEquals(-1, FirstDuplicate.firstDuplicate(new int[]{10, 6, 8, 4, 9, 1, 7, 2, 5, 3}));
    }

    @Test
    public void test5() throws Exception {
        assertEquals(6, FirstDuplicate.firstDuplicate(new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8}));
    }
}