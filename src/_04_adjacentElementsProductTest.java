package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _04_adjacentElementsProductTest {
    static final _04_adjacentElementsProduct obj = new _04_adjacentElementsProduct();

    @Test
    void adjacentElementsProduct() {
        assertEquals(obj.adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}), 21);
    }
}