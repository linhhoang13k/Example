package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _41_digitDegreeTest {
    static final _41_digitDegree obj = new _41_digitDegree();

    @Test
    void digitDegree() {
        assertEquals(obj.digitDegree(5), 0);
        assertEquals(obj.digitDegree(100), 1);
        assertEquals(obj.digitDegree(91), 2);
        assertEquals(obj.digitDegree(99), 2);
    }

}