package Arcade_Intro;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class _20_arrayMaximalAdjacentDifferenceTest {
    final static _20_arrayMaximalAdjacentDifference obj = new _20_arrayMaximalAdjacentDifference();

    @Test
    void arrayMaximalAdjacentDifference() {
        assertEquals(obj.arrayMaximalAdjacentDifference(new int[] {2,4,1,0}), 3);
        assertEquals(obj.arrayMaximalAdjacentDifference(new int[] {1, 1, 1, 1}), 0);
        assertEquals(obj.arrayMaximalAdjacentDifference(new int[] {-1, 4, 10, 3, -2}), 7);
    }

}