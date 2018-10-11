package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _21_isIPv4AddressTest {
    final static _21_isIPv4Address obj = new _21_isIPv4Address();

    @Test
    void isIPv4Address() {
        assertEquals(obj.isIPv4Address("....."), false);
        assertEquals(obj.isIPv4Address("172.16.254.1"), true);
        assertEquals(obj.isIPv4Address("172.316.254.1"), false);
        assertEquals(obj.isIPv4Address(".254.255.0"), false);
        assertEquals(obj.isIPv4Address("1.1.1.1a"), false);
    }

}