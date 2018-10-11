package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _40_longestDigitsPrefixTest {
    final static _40_longestDigitsPrefix obj = new _40_longestDigitsPrefix();

    @Test
    void longestDigitsPrefix() {
        assertEquals(obj.longestDigitsPrefix("123aa1"), "123");
        assertEquals(obj.longestDigitsPrefix("0123456789"), "0123456789");
        assertEquals(obj.longestDigitsPrefix("  3) always check for whitespaces"), "");
        assertEquals(obj.longestDigitsPrefix("12abc34"), "12");
        assertEquals(obj.longestDigitsPrefix("the output is 42"), "");
    }

}