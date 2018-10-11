package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _30_circleOfNumbersTest {
    final static _30_circleOfNumbers obj = new _30_circleOfNumbers();

    @Test
    void circleOfNumbers() {
        assertEquals(obj.circleOfNumbers(10, 2), 7);
        assertEquals(obj.circleOfNumbers(10, 7), 2);
        assertEquals(obj.circleOfNumbers(4, 1), 3);
        assertEquals(obj.circleOfNumbers(6, 3), 0);
    }

}