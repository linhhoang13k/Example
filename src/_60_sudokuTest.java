package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _60_sudokuTest {
    final static _60_sudoku obj = new _60_sudoku();

    @Test
    void sudoku() {
        assertEquals(obj.sudoku(new int[][]{
                new int[]{1,3,2,5,4,6,9,8,7},
                new int[]{4,6,5,8,7,9,3,2,1},
                new int[]{7,9,8,2,1,3,6,5,4},
                new int[]{9,2,1,4,3,5,8,7,6},
                new int[]{3,5,4,7,6,8,2,1,9},
                new int[]{6,8,7,1,9,2,5,4,3},
                new int[]{5,7,6,9,8,1,4,3,2},
                new int[]{2,4,3,6,5,7,1,9,8},
                new int[]{8,1,9,3,2,4,7,6,5}}), true);
    }

}