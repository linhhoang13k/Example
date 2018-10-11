package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _10_commonCharacterCountTest {
    final static _10_commonCharacterCount obj = new _10_commonCharacterCount();

    @Test
    void commonCharacterCount() {
        assertEquals(obj.commonCharacterCount("aabcc", "adcaa"), 3);
        assertEquals(obj.commonCharacterCount("zzzz", "zzzzzzz"), 4);
        assertEquals(obj.commonCharacterCount("abca", "xyzbac"), 3);
    }

}