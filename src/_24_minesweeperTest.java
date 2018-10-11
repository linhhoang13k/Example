package Arcade_Intro;

import Arcade_Intro._24_minesweeper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _24_minesweeperTest {
    final static _24_minesweeper obj = new _24_minesweeper();

    @Test
    void minesweeper() {
        assertArrayEquals(obj.minesweeper(
                new boolean[][]{new boolean[]{true, false, false},
                                new boolean[]{false, true, false},
                                new boolean[]{false, false, false}}),
                new int[][]{new int[]{1, 2, 1}, new int[]{2, 1, 1}, new int[]{1, 1, 1}});
    }

}