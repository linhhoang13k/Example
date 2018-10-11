package Arcade_Intro;

import static org.junit.jupiter.api.Assertions.*;

class _59_spiralNumbersTest {
    final static _59_spiralNumbers obj = new _59_spiralNumbers();

    @org.junit.jupiter.api.Test
    void spiralNumbers() {
        // assertArrayEquals(obj.spiralNumbers(3), new int[][]{new int[]{1,2,3}, new int[]{8,9,4}, new int[]{7,6,5}});
        //assertArrayEquals(obj.spiralNumbers(5), new int[][]{new int[]{1,2,3,4,5}, new int[]{16,17,18,19,6}, new int[]{15,24,25,20,7}, new int[]{14,23,22,21,8},new int[]{13,12,11,10,9}});
        assertArrayEquals(obj.spiralNumbers(6), new int[][]{new int[]{1,2,3,4,5,6},
                new int[]{20,21,22,23,24,7}, new int[]{19,32,33,34,25,8}, new int[]{18,31,36,35,26,9},new int[]{17,30,29,28,27,10}, new int[]{16,15,14,13,12,11}});

    }

}