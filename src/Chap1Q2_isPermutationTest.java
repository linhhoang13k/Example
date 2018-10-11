package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/6/2017.
 */
public class Chap1Q2_isPermutationTest {

    @Test
    public void testDifLength() throws Exception {
        assertEquals("Test failed: Dif length, same character count",
                false,
                Chap1Q2_isPermutation.isPermutation("abc", "bdda"));

    }

    @Test
    public void testSameLengthSameCharCount() throws Exception {
        assertEquals("Test failed: Same length, same character count",
                true,
                Chap1Q2_isPermutation.isPermutation("abcd", "bdca"));

    }

    @Test
    public void testSameLengthDiffCharCount() throws Exception {
        assertEquals("Test failed: Same length, different character count",
                false,
                Chap1Q2_isPermutation.isPermutation("abcd", "bdda"));

    }



}