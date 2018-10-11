package Array_Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/10/2017.
 */
public class Chap1Q4_PalindromePermutationTest {
    @Test
    public void palindromePermutation() throws Exception {
        assertEquals("Test failed: is permutation a palindrome", true,
                Chap1Q4_PalindromePermutation.palindromePermutation("tact coa"));
        assertEquals("Test failed: is permutation a palindrome", false,
                Chap1Q4_PalindromePermutation.palindromePermutation("aab a"));
    }

}