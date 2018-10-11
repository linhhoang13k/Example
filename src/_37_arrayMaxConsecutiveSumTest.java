package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _37_arrayMaxConsecutiveSumTest {
    static final _37_arrayMaxConsecutiveSum obj = new _37_arrayMaxConsecutiveSum();

    @Test
    void arrayMaxConsecutiveSum() {
        assertEquals(obj.arrayMaxConsecutiveSum(new int[]{2, 3, 5, 1, 6}, 2), 8);
        assertEquals(obj.arrayMaxConsecutiveSum(new int[]{2, 4, 10, 1}, 2), 14);
        assertEquals(obj.arrayMaxConsecutiveSum(new int[]{1, 3, 2, 4}, 3), 9);
    }

}