package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _22_avoidObstaclesTest {
    static final _22_avoidObstacles obj = new _22_avoidObstacles();

    @Test
    void avoidObstacles() {
        assertEquals(obj.avoidObstacles(new int[] {5, 3, 6, 7, 9}), 4);
        assertEquals(obj.avoidObstacles(new int[] {2, 3}), 4);
        assertEquals(obj.avoidObstacles(new int[] {1, 4, 10, 6, 2}), 7);
    }
}