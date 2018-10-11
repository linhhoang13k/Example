package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _55_differentSquaresTest {
    final static _55_differentSquares obj = new _55_differentSquares();


    @Test
    void differentSquares() {

        assertEquals(obj.differentSquares(new int[][]{
                new int[]{2,5,3,4,3,1,3,2},
                new int[]{4,5,4,1,2,4,1,3},
                new int[]{1,1,2,1,4,1,1,5},
                new int[]{1,3,4,2,3,4,2,4},
                new int[]{1,5,5,2,1,3,1,1},
                new int[]{1,2,3,3,5,1,2,4},
                new int[]{3,1,4,4,4,1,5,5},
                new int[]{5,1,3,3,1,5,3,5},
                new int[]{5,4,4,3,5,4,4,4}}), 54);
        assertEquals(obj.differentSquares(new int[][]{new int[]{1,2,1},
                new int[]{2,2,2},
                new int[]{2,2,2},
                new int[]{1,2,3},
                new int[]{2,2,1}}), 6);
        assertEquals(obj.differentSquares(new int[][]{new int[]{9,9,9,9,9},
                new int[]{9,9,9,9,9},
                new int[]{9,9,9,9,9},
                new int[]{9,9,9,9,9},
                new int[]{9,9,9,9,9},
                new int[]{9,9,9,9,9}}), 1);
    }

}