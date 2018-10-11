package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _51_deleteDigitTest {
    static final _51_deleteDigit obj = new _51_deleteDigit();

    @Test
    void deleteDigit() {
        //assertEquals(obj.deleteDigit(152), 52);
        //assertEquals(obj.deleteDigit(1001), 101);
        assertEquals(obj.deleteDigit(10), 1);
        assertEquals(obj.deleteDigit(222219), 22229);
    }

}