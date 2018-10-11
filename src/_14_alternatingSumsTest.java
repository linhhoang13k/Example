package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _14_alternatingSumsTest {
    final static _14_alternatingSums obj = new _14_alternatingSums();

    @Test
    void alternatingSums() {
        assertArrayEquals(obj.alternatingSums(new int[]{50, 60, 60, 45, 70}), new int[]{180,105});
        assertArrayEquals(obj.alternatingSums(new int[]{100,50}), new int[]{100,50});
        assertArrayEquals(obj.alternatingSums(new int[]{100}), new int[]{100,0});
    }

}