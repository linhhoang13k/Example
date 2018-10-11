package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _54_sumUpNumbersTest {
    final static _54_sumUpNumbers obj = new _54_sumUpNumbers();

    @Test
    void sumUpNumbers() {
        assertEquals(obj.sumUpNumbers("2 apples, 12 oranges"), 14);
        assertEquals(obj.sumUpNumbers("123450"), 123450);
        assertEquals(obj.sumUpNumbers("Your payment method is invalid"), 0);
    }

}