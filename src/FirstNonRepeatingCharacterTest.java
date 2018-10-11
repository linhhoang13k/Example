package com.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstNonRepeatingCharacterTest {

    @Test
    public void test1() throws Exception {
        assertEquals('c', FirstNotRepeatingCharacter.firstNonRepeatingCharacter("abacabad"));
    }

    @Test
    public void test2() throws Exception {
        assertEquals('_', FirstNotRepeatingCharacter.firstNonRepeatingCharacter("abacabaabacaba"));
    }
    @Test
    public void test3() throws Exception {
        assertEquals('z', FirstNotRepeatingCharacter.firstNonRepeatingCharacter("z"));
    }
    @Test
    public void test4() throws Exception {
        assertEquals('c', FirstNotRepeatingCharacter.firstNonRepeatingCharacter("bcb"));
    }
}
