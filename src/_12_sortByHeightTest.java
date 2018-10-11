package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _12_sortByHeightTest {
    final static _12_sortByHeight obj = new _12_sortByHeight();

    @Test
    void sortByHeight() {
        assertArrayEquals(obj.sortByHeight(new int[]{-1, 150, 190, 170, -1, -1, 160, 180}),
                new int[]{-1, 150, 160, 170, -1, -1, 180, 190});
        assertArrayEquals(obj.sortByHeight(new int[]{-1, -1, -1, -1, -1}),
                new int[]{-1, -1, -1, -1, -1});
    }
}