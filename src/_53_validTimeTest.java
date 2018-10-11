package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _53_validTimeTest {
    public static _53_validTime obj = new _53_validTime();

    @Test
    void validTime() {
        assertEquals(obj.validTime("13:58"),true);
        assertEquals(obj.validTime("25:51"),false);
        assertEquals(obj.validTime("02:76"),false);
        assertEquals(obj.validTime("24:00"),false);
    }

}