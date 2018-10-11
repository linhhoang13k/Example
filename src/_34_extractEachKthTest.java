package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _34_extractEachKthTest {
    static final _34_extractEachKth obj = new _34_extractEachKth();

    @Test
    void extractEachKth() {
        assertArrayEquals(obj.extractEachKth(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3), new int[]{1, 2, 4, 5, 7, 8, 10});
        assertArrayEquals(obj.extractEachKth(new int[]{ 1, 1, 1, 1, 1}, 1), new int[]{});
        assertArrayEquals(obj.extractEachKth(new int[]{ 1, 2, 1, 2, 1, 2, 1, 2}, 2), new int[]{1, 1, 1, 1});
    }

}