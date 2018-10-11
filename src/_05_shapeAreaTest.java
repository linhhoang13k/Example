package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _05_shapeAreaTest {
    final static _05_shapeArea obj = new _05_shapeArea();

    @Test
    void shapeArea(){
        assertEquals(obj.shapeArea(3),13);
        assertEquals(obj.shapeArea(2),5);
        assertEquals(obj.shapeArea(5),41);
        assertEquals(obj.shapeArea(1),1);
    }
}