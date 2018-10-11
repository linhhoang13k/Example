package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _33_stringsRearrangementTest {
    final static _33_stringsRearrangement obj = new _33_stringsRearrangement();

    @Test
    void stringsRearrangement() {
//        assertEquals(obj.stringsRearrangement(new String[] {"aba", "bbb", "bab"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"ab", "bb", "aa"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"q", "q"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"zzzzab", "zzzzbb", "zzzzaa"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"ab", "ad", "ef", "eg"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "abx", "axx", "abc"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "bef", "bcc", "bec", "bbc", "bdc"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "abx", "axx", "abc"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "abx", "axx", "abx", "abc"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"f", "g", "a", "h"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"ff", "gf", "af", "ar", "hf"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"oh", "eh", "ah", "po", "op"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"zzzabzczaba", "zzzabzczaaa", "zzzabzczabb", "zzzabzczbbb"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"zzzabzczaaa", "zzzabzczaaa", "zzzabzczaaa", "zzzabzczaaa"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "xbc", "xxc", "xbc", "aby", "ayy", "aby", "azc"}), false);
//        assertEquals(obj.stringsRearrangement(new String[] {"abc", "bef", "bcc", "bew", "zew", "zyw", "bec", "bbc", "bdc"}), true);
//        assertEquals(obj.stringsRearrangement(new String[] {"abacabaabczzzzz", "abacababefzzzzz", "abacababcczzzzz", "abacababeczzzzz", "abacababbczzzzz", "abacababdczzzzz"}), true);
        assertEquals(obj.stringsRearrangement(new String[] {"abc", "xbc", "xxc", "xbc", "aby", "ayy", "aby"}), true);
        assertEquals(obj.stringsRearrangement(new String[] {"abc", "xbc", "axc", "abx"}), false);

    }

}