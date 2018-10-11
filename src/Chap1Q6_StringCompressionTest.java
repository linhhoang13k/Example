package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/10/2017.
 */
public class Chap1Q6_StringCompressionTest {
    @Test
    public void compress() throws Exception {
        assertEquals("Test failed: compression of string", "a2b2c3",
                Chap1Q6_StringCompression.compress("aabbccc"));
        assertEquals("Test failed: compression of overlaping characters string", "aabbacdcc",
                Chap1Q6_StringCompression.compress("aabbacdcc"));
        assertEquals("Test failed: compression of empty string", "",
                Chap1Q6_StringCompression.compress(""));
        assertEquals("Test failed: compression of string unnecessarily", "abc",
                Chap1Q6_StringCompression.compress("abc"));
    }

}