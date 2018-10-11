package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _52_longestWordTest {
    final static _52_longestWord obj = new _52_longestWord();

    @Test
    void longestWord() {
        assertEquals(obj.longestWord("Ready, steady, go!"), "steady");
        assertEquals(obj.longestWord("Ready[[[, steady, go!"), "steady");
        assertEquals(obj.longestWord("ABCd"), "ABCd");
    }

}