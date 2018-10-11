package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 5/30/2017.
 */
public class Chap1Q1_IsUniqueTest {

    @Test
    public void testUnique() {
        assertEquals("Unique characters test failed", Chap1Q1_IsUnique.isUnique("abcd"), true);
        assertEquals("Unique characters test failed", Chap1Q1_IsUnique.isUniqueWithNoDataStructure("abcd"), true);

    }

    @Test
    public void testNotUnique() {
        assertEquals("Not unique characters test failed", Chap1Q1_IsUnique.isUnique("abccd"), false);
        assertEquals("Not unique characters test failed", Chap1Q1_IsUnique.isUniqueWithNoDataStructure("abccd"), false);

    }

    @Test
    public void testEmpty() {
        assertEquals("Empty input test failed", Chap1Q1_IsUnique.isUnique(""), true);
        assertEquals("Empty input test failed", Chap1Q1_IsUnique.isUniqueWithNoDataStructure(""), true);

    }

    @Test
    public void testOneChar() {
        assertEquals("Input with 1 character test failed", Chap1Q1_IsUnique.isUnique("a"), true);
        assertEquals("Input with 1 character test failed", Chap1Q1_IsUnique.isUniqueWithNoDataStructure("a"), true);

    }

    @Test (expected = AssertionError.class)
    public void testException() {
        assertEquals("Unique characters test failed", Chap1Q1_IsUnique.isUnique("abc"), false);
        assertEquals("Unique characters test failed", Chap1Q1_IsUnique.isUniqueWithNoDataStructure("abc"), false);

    }

}