package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _18_palindromeRearrangingTest {
    final static _18_palindromeRearranging obj = new _18_palindromeRearranging();

    @Test
    void palindromeRearranging() {
        assertEquals(obj.palindromeRearranging("aabb"), true);
        assertEquals(obj.palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"), false);
        assertEquals(obj.palindromeRearranging("abbcabb"), true);
        assertEquals(obj.palindromeRearranging("zyyzzzzz"), true);
        assertEquals(obj.palindromeRearranging("z"), true);
    }
}