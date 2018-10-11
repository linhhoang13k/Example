package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _26_evenDigitsOnlyTest {
    static final _26_evenDigitsOnly obj = new _26_evenDigitsOnly();

    @Test
    void evenDigitsOnly() {
        assertEquals(obj.evenDigitsOnly(248622), true);
        assertEquals(obj.evenDigitsOnly(642386), false);
        assertEquals(obj.evenDigitsOnly(1), false);
        assertEquals(obj.evenDigitsOnly(2462487), false);
        assertEquals(obj.evenDigitsOnly(248842), true);
        assertEquals(obj.evenDigitsOnly(8), true);
    }

}