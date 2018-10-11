package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _43_isBeautifulStringTest {
    final static _43_isBeautifulString obj = new _43_isBeautifulString();

    @Test
    void isBeautifulString() {
        assertEquals(obj.isBeautifulString("bbbaacdafe"), true);
        assertEquals(obj.isBeautifulString("aabbb"), false);
        assertEquals(obj.isBeautifulString("bbc"), false);
        assertEquals(obj.isBeautifulString("bbbaa"), false);
        assertEquals(obj.isBeautifulString("abcdefghijklmnopqrstuvwxyzz"), false);
        assertEquals(obj.isBeautifulString("abcdefghijklmnopqrstuvwxyz"), true);
        assertEquals(obj.isBeautifulString("abcdefghijklmnopqrstuvwxyzqwertuiopasdfghjklxcvbnm"), true);
        assertEquals(obj.isBeautifulString("fyudhrygiuhdfeis"), false);
        assertEquals(obj.isBeautifulString("zaa"), false);
        assertEquals(obj.isBeautifulString("zyy"), false);
    }
}