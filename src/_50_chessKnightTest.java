package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _50_chessKnightTest {
    final static _50_chessKnight obj = new _50_chessKnight();

    @Test
    void chessKnight() {
        assertEquals(obj.chessKnight("a1"), 2);
        assertEquals(obj.chessKnight("c2"), 6);
        assertEquals(obj.chessKnight("d4"), 8);
        assertEquals(obj.chessKnight("g6"), 6);
    }
}