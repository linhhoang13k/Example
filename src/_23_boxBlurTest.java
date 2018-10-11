package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _23_boxBlurTest {
    final static _23_boxBlur obj = new _23_boxBlur();

    @Test
    void boxBlur() {
        assertArrayEquals(obj.boxBlur(new int[][]{
                new int[]{36,0,18,9},
                new int[]{27,54,9,0},
                new int[]{81,63,72,45}}),
                new int[][]{new int[]{40,30}});
    }

}