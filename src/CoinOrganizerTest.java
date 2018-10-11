package com.paigeruppel.interviewpractice.hashtables;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CoinOrganizerTest {

    private CoinOrganizer underTest;

    @Before
    public void setup() {
        underTest = new CoinOrganizer();
    }

    @Test
    public void coinsWithValueGreaterThan10ShouldReturn9TestCase1() {
        int[] coins = {10, 50, 100}; // 5 5 25 25 25 25 25 25
        int[] quantities = {1, 2, 1};
        assertThat(underTest.possibleSums(coins, quantities), is(9));
    }

    @Test
    public void coinsWithValueGreaterThan10ShouldReturn122TestCase2() {
        int[] coins = {10, 50, 100, 500};
        int[] quantities = {5, 3, 2, 2};
        assertThat(underTest.possibleSums(coins, quantities), is(122));
    }

    @Test
    public void coinsWithValueLessThan10ShouldReturnQuantity5TestCase3() {
        int[] coins = {1};
        int[] quantities = {5};
        assertThat(underTest.possibleSums(coins, quantities), is(5));
    }

    @Test
    public void coinsWithValueLessThan10ShouldReturnQuantity5TestCase4() {
        int coins[] = {1, 1};
        int quantities[] = {2, 3};
        assertThat(underTest.possibleSums(coins, quantities), is(5));
    }

    @Test
    public void coinsWithValueLessThan10ShouldReturnQuantityProduct50004TestCase5() {
        int[] coins = {1, 2};
        int[] quantities = {50000, 2};
        assertThat(underTest.possibleSums(coins, quantities), is(50004));
    }

    @Test
    public void coinsWithValueLessThan10ShouldReturnQuantityProduct30008TestCase6() {
        int[] coins = {1, 2, 3};
        int[] quantities = {2, 3, 10000};
        assertThat(underTest.possibleSums(coins, quantities), is(30008));
    }

    @Test
    public void coinsWithValueLessThan10ShouldReturnQuantityProduct521TestCase7() {
        int[] coins = {3, 1, 1};
        int[] quantity = {111, 84, 104};
        assertThat(underTest.possibleSums(coins, quantity), is(521));
    }

    @Test
    public void testCase8() {
        int[] coins = {1, 1, 1, 1, 1};
        int[] quantities = {9, 19, 18, 12, 19};
        assertThat(underTest.possibleSums(coins, quantities), is(77));
    }


    @Test
    public void testCase9() {
        int[] coins = {3, 2, 5, 2, 3, 5, 4};
        int[] quantities = {4, 6, 4, 9, 6, 8, 8};
        assertThat(underTest.possibleSums(coins, quantities), is(150));
    }

}
