package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _36_differentSymbolsNaiveTest {
    static final _36_differentSymbolsNaive obj = new _36_differentSymbolsNaive();

    @Test
    void differentSymbolsNaive() {
        assertEquals(obj.differentSymbolsNaive("cabca"), 3);
        assertEquals(obj.differentSymbolsNaive("aba"), 2);
    }

}