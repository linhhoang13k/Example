package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _31_depositProfitTest {
    final static _31_depositProfit obj = new _31_depositProfit();

    @Test
    void depositProfit() {
        assertEquals(obj.depositProfit(100,20,170), 3);
        assertEquals(obj.depositProfit(1,100,64), 6);
        assertEquals(obj.depositProfit(100,1,101), 1);
    }

}