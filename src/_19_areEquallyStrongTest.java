package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _19_areEquallyStrongTest {
    final static _19_areEquallyStrong obj = new _19_areEquallyStrong();

    @Test
    void areEquallyStrong() {
        assertEquals(obj.areEquallyStrong(10,15,15,10), true);
        assertEquals(obj.areEquallyStrong(15,10,15,10), true);
        assertEquals(obj.areEquallyStrong(15,10,15,9), false);
    }

}