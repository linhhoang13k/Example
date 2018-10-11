package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/10/2017.
 */
public class Chap1Q5_OneAwayTest {
    @Test
    public void isOneAway() throws Exception {
        assertEquals("Test failed: is 1 or zero edits away", true,
                Chap1Q5_OneAway.isOneAway("pale", "pal"));
        assertEquals("Test failed:  > 1 edits away", false,
                Chap1Q5_OneAway.isOneAway("pale", "bake"));
        assertEquals("Test failed: zero edits away", true,
                Chap1Q5_OneAway.isOneAway("pale", "pale"));
        assertEquals("Test failed: 1 edit away", true,
                Chap1Q5_OneAway.isOneAway("pale", "bale"));
    }

}