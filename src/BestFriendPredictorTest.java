package com.paigeruppel.codefights.challenges;

import org.junit.Before;
import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BestFriendPredictorTest {

    private BestFriendPredictor underTest;

    @Before
    public void setup() {
        underTest = new BestFriendPredictor();
    }

    @Test
    public void isBestFriendNamesShouldReturnTrueForBobAndDan() {
        assertTrue(underTest.bestFriendNames("Bob", "Dan"));
    }

    @Test
    public void isBestFriendNamesFalseForAliceAndDiego() {
        assertFalse(underTest.bestFriendNames("Alice", "Diego"));
    }

    @Test
    public void isBestFriendNamesFalseForBruceAndClark() {
        assertFalse(underTest.bestFriendNames("Alice", "Diego"));
    }

    @Test
    public void isBestFriendNamesTrueForThorAndMulan() {
        assertTrue(underTest.bestFriendNames("Thor", "Mulan"));
    }


}



