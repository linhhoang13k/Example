package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _08_matrixElementsSumTest {
    final static _08_matrixElementsSum obj = new _08_matrixElementsSum();

    @Test
    void matrixElementsSum() {
        assertEquals(obj.matrixElementsSum(new int[][] {new int[] {0,1,1,2}, new int[]{0,5,0,0}, new int[]{2,0,3,3}}), 9);
        assertEquals(obj.matrixElementsSum(new int[][] {new int[] {1,1,1,0}, new int[]{0,5,0,1}, new int[]{2,1,3,10}}), 9);
        assertEquals(obj.matrixElementsSum(new int[][] {new int[] {1,1,1}, new int[]{2,2,2}, new int[]{3,3,3}}), 18);
    }
}