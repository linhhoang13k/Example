package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _11_isLuckyTest {
    final static _11_isLucky obj = new _11_isLucky();

    @Test
    void isLucky() {
        assertEquals(obj.isLucky(1230),true);
        assertEquals(obj.isLucky(239017),false);
        assertEquals(obj.isLucky(134008),true);
        assertEquals(obj.isLucky(10),false);
    }
}