package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _39_knapsackLightTest {
    final static _39_knapsackLight obj = new _39_knapsackLight();

    @Test
    void knapsackLight() {
        assertEquals(obj.knapsackLight(10,5,6,4,8),10);
        assertEquals(obj.knapsackLight(10,5,6,4,9),16);
        assertEquals(obj.knapsackLight(5,3,7,4,6),7);
        assertEquals(obj.knapsackLight(10,2,11,3,1),0);
        assertEquals(obj.knapsackLight(4,3,3,4,4),4);
    }

}