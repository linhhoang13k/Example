package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _03_checkPalindromeTest {
    final static _03_checkPalindrome obj = new _03_checkPalindrome();

    @Test
    void checkPalindrome() {
        assertEquals(obj.checkPalindrome("aabaa"), true);
        assertEquals(obj.checkPalindrome("abac"), false);
        assertEquals(obj.checkPalindrome("a"), true);
        assertEquals(obj.checkPalindrome("az"), false);
        assertEquals(obj.checkPalindrome("abacaba"), true);
        assertEquals(obj.checkPalindrome("aaabaaaa"), false);
    }
}