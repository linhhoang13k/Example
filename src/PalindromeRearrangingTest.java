import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PalindromeRearrangingTest {
    @Test
    public void test1() {
        assertTrue(PalindromeRearranging.palindromeRearranging("zzzzz"));
    }
    @Test
    public void test2() {
        assertTrue(PalindromeRearranging.palindromeRearranging("aabcc"));
    }
}
