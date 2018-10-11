package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _06_makeArrayConsecutive2Test {
    final static _06_makeArrayConsecutive2 obj = new _06_makeArrayConsecutive2();

    @Test
    void makeArrayConsecutive2() {
        assertEquals(obj.makeArrayConsecutive2(new int[]{6, 2, 3, 8}), 3);
        assertEquals(obj.makeArrayConsecutive2(new int[]{0, 3}), 2);
        assertEquals(obj.makeArrayConsecutive2(new int[]{5, 4, 6}), 0);
    }

}