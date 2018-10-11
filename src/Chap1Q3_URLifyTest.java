package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/10/2017.
 */
public class Chap1Q3_URLifyTest {
    @Test
    public void urlify() throws Exception {
        assertEquals("Test failed: ULRify string", "Mr%20John%20Doe",
                Chap1Q3_URLify.urlify(
                        new char[] {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'D', 'o', 'e', ' ', ' ', ' ', ' '},11));
    }

}