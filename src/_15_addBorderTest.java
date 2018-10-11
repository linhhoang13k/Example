package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _15_addBorderTest {
    final static _15_addBorder obj = new _15_addBorder();
    @Test
    void addBorder() {
        assertArrayEquals(obj.addBorder(new String[]{"abc","ded"}),new String[]{"*****","*abc*", "*ded*","*****"});
    }

}