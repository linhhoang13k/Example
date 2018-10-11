package Arcade_Core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _032_roundersTest {
    _032_rounders obj = new _032_rounders();

    @Test
    void test_rounders() {
        assertEquals(obj.rounders(15), 20);
        assertEquals(obj.rounders(1234), 1000);
    }
}