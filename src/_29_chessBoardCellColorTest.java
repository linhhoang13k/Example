package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _29_chessBoardCellColorTest {
    final static _29_chessBoardCellColor obj = new _29_chessBoardCellColor();

    @Test
    void chessBoardCellColor() {
        assertEquals(obj.chessBoardCellColor("A1", "C3"), true);
        assertEquals(obj.chessBoardCellColor("A1", "H3"), false);
        assertEquals(obj.chessBoardCellColor("A1", "A2"), false);
        assertEquals(obj.chessBoardCellColor("A1", "B2"), true);
    }

}