package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _47_isMAC48AddressTest {
    static final _47_isMAC48Address obj = new _47_isMAC48Address();

    @Test
    void isMAC48Address() {
        assertEquals(obj.isMAC48Address("00-1B-63-84-45-E6"), true);
        assertEquals(obj.isMAC48Address("Z1-1B-63-84-45-E6"), false);
        assertEquals(obj.isMAC48Address("not a MAC-48 address"), false);
        assertEquals(obj.isMAC48Address("FF-FF-FF-FF-FF-FF"), true);


    }

}