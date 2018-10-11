package Arcade_Core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _030_appleBoxesTest {
    public static final _030_appleBoxes obj = new _030_appleBoxes();

    @Test
    void appleBoxes() {
        assertEquals(obj.appleBoxes(0), 0);
        assertEquals(obj.appleBoxes(3), -6);
        assertEquals(obj.appleBoxes(5), -15);
    }

}