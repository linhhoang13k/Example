package arcade.exploringthewaters;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AddBorderTest {

    @Test
    public void BorderAroundSingleCharacter() {
        String[] input = new String[] { "a" };
        String[] expected = new String[] { "***", "*a*", "***" };

        assertArrayEquals(expected, addBorder(input));
    }

    @Test
    public void BorderAroundTwoLines() {
        String[] input = new String[] { "abc", "ded" };
        String[] expected = new String[] { "*****", "*abc*", "*ded*", "*****" };

        assertArrayEquals(expected, addBorder(input), "Need to loop on input on line 33");
    }

    private String[] addBorder(String[] picture) {
        String[] result = new String[picture.length + 2];
        result[0] = addOuterBorder(picture[0].length());
        int i = 0;
        while ( i < picture.length) {
            result[i + 1] = "*" + picture[i] + "*";
            ++i;
        }
        result[i + 1] = addOuterBorder(picture[0].length());
        return result;
    }

    private String addOuterBorder(int length) {
        char[] result = new char[length + 2];
        Arrays.fill(result, '*');
        return new String(result);
    }
}
