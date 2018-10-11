package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _48_isDigitTest {
    final static _48_isDigit obj = new _48_isDigit();


    @Test
    void isDigit() {
        assertEquals(obj.isDigit('0'), true);
        assertEquals(obj.isDigit('1'), true);
        assertEquals(obj.isDigit('-'), false);
        assertEquals(obj.isDigit('O'), false);
    }

}