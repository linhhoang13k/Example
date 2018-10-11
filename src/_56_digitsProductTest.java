package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _56_digitsProductTest {
    _56_digitsProduct obj = new _56_digitsProduct();

    @Test
    void digitsProduct() {
        assertEquals(obj.digitsProduct(12), 26);
        assertEquals(obj.digitsProduct(19), -1);
        assertEquals(obj.digitsProduct(450), 2559);
        assertEquals(obj.digitsProduct(0), 10);
        assertEquals(obj.digitsProduct(13), -1);
        assertEquals(obj.digitsProduct(1), 1);
        assertEquals(obj.digitsProduct(243), 399);
    }

}