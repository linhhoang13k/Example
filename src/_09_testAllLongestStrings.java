package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _09_testAllLongestStrings {
    final static _09_allLongestStrings obj = new _09_allLongestStrings();

    @Test
    void allLongestStrings() {
        assertArrayEquals(obj.allLongestStrings(new String[]{"a", "aa", "abc"}), new String[]{"abc"});
        assertArrayEquals(obj.allLongestStrings(new String[]{"aba", "aa", "ad", "vcd", "aba"}), new String[]{"aba", "vcd", "aba"});
    }

}