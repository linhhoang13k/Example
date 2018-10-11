package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _49_lineEncodingTest {
    _49_lineEncoding obj = new _49_lineEncoding();

    @Test
    void lineEncoding() {
        assertEquals(obj.lineEncoding("aabbbc"), "2a3bc");
        assertEquals(obj.lineEncoding("abbcabb"), "a2bca2b");
        assertEquals(obj.lineEncoding("abcd"), "abcd");
    }

}