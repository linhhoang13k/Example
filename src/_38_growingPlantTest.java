package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _38_growingPlantTest {
    static final _38_growingPlant obj = new _38_growingPlant();

    @Test
    void growingPlant() {
        assertEquals(obj.growingPlant(100,10,910), 10);
        assertEquals(obj.growingPlant(10,9,4), 1);
    }

}