package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _45_buildPalindromeTest {
    final static _45_buildPalindrome obj = new _45_buildPalindrome();

    @Test
    void buildPalindrome() {
        assertEquals(obj.buildPalindrome("abcdc"), "abcdcba");
        assertEquals(obj.buildPalindrome("ababab"), "abababa");
        assertEquals(obj.buildPalindrome("abba"), "abba");
        assertEquals(obj.buildPalindrome("abaa"), "abaaba");
    }

}