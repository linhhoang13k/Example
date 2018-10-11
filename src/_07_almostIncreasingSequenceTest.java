package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _07_almostIncreasingSequenceTest {
    final static _07_almostIncreasingSequence obj = new _07_almostIncreasingSequence();

    @Test
    void almostIncreasingSequence(){
        assertEquals(obj.almostIncreasingSequence(new int[]{1, 3, 2, 1}),false);
        assertEquals(obj.almostIncreasingSequence(new int[]{1, 3, 2}),true);
        assertEquals(obj.almostIncreasingSequence(new int[]{1, 2, 1, 2}),false);
        assertEquals(obj.almostIncreasingSequence(new int[]{1, 2, 1, 4}),true);
        assertEquals(obj.almostIncreasingSequence(new int[]{1, 3, 2, 3}),true);
    }
}