package Arcade_Core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _031_increaseNumberRoundnessTest {
    static final _031_increaseNumberRoundness obj = new _031_increaseNumberRoundness();

    @Test
    void increaseNumberRoundness() {
        assertEquals(obj.increaseNumberRoundness(902200100), true);
        assertEquals(obj.increaseNumberRoundness(11000), false);
        assertEquals(obj.increaseNumberRoundness(99080), true);
    }

}