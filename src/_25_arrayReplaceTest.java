package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _25_arrayReplaceTest {
    final static _25_arrayReplace obj = new _25_arrayReplace();

    @Test
    void arrayReplace() {
        assertArrayEquals(obj.arrayReplace(new int[]{1, 2, 1}, 1, 3), new int[]{3,2,3});
        assertArrayEquals(obj.arrayReplace(new int[]{1, 2, 3, 4, 5}, 3, 0), new int[]{1, 2, 0, 4, 5});
        assertArrayEquals(obj.arrayReplace(new int[]{1, 1, 1}, 1, 10), new int[]{10,10,10});
    }

}