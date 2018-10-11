package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _28_alphabeticShiftTest {
    static final _28_alphabeticShift obj = new _28_alphabeticShift();

    @Test
    void alphabeticShift() {
        assertEquals(obj.alphabeticShift("crazy"), "dsbaz");
        assertEquals(obj.alphabeticShift("z"), "a");
    }
}