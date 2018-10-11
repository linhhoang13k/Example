package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _17_arrayChangeTest {
    final static _17_arrayChange obj = new _17_arrayChange();

    @Test
    void arrayChange() {
        assertEquals(obj.arrayChange(new int[]{1,1,1}), 3);
        assertEquals(obj.arrayChange(new int[]{-1000, 0, -2, 0}), 5);
        assertEquals(obj.arrayChange(new int[]{2, 1, 10, 1}), 12);
        assertEquals(obj.arrayChange(new int[]{2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15}), 13);
    }

}