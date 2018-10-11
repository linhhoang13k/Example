package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _46_electionsWinnersTest {
    static final _46_electionsWinners obj = new _46_electionsWinners();

    @Test
    void electionsWinners() {
        assertEquals(obj.electionsWinners(new int[]{2, 3, 5, 2},3), 2);
        assertEquals(obj.electionsWinners(new int[]{1, 3, 3, 1, 1},0), 0);
        assertEquals(obj.electionsWinners(new int[]{5, 1, 3, 4, 1},0), 1);
        assertEquals(obj.electionsWinners(new int[]{1, 1, 1, 1},1), 4);
        assertEquals(obj.electionsWinners(new int[]{1, 1, 1, 1},0), 0);
        assertEquals(obj.electionsWinners(new int[]{3, 1, 1, 3, 1},2), 2);
    }

}