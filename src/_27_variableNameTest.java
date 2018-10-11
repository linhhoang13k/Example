package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _27_variableNameTest {
    final static _27_variableName obj = new _27_variableName();

    @Test
    void variableName() {
        assertEquals(obj.variableName("var_1__Int"), true);
        assertEquals(obj.variableName("qq-q"), false);
        assertEquals(obj.variableName("2w2"), false);
        assertEquals(obj.variableName(" variable"), false);
        assertEquals(obj.variableName("va[riable0"), false);
        assertEquals(obj.variableName("variable0"), true);
    }

}