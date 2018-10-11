package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _35_firstDigitTest {
    final static _35_firstDigit obj = new _35_firstDigit();

    @Test
    void firstDigit() {
        assertEquals(obj.firstDigit("var_1__Int"), '1');
        assertEquals(obj.firstDigit("q2q-q"), '2');
        assertEquals(obj.firstDigit("0ss"), '0');
    }

}