package interviewpractice.hashTables;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class AreFollowingPatternsTest {

    private AreFollowingPatterns are = new AreFollowingPatterns();

    private String[] testStrs = new String[]{
            "cat", "dog", "dog"
    };
    private String[] testPats = new String[]{"a", "b", "b"};

    private String[] testStrs2 = new String[] {"cat", "dog", "doggy"};
    private String[] testPats2 = new String[] {"a", "b", "b"};

    @Test
    public void testAreFollowingPatternsOne() {
        boolean result = are.areFollowingPatterns(testStrs, testPats);
        assertTrue(result);
    }

    @Test
    public void testAreFollowingPatternsTwo() {
        boolean result = are.areFollowingPatterns(testStrs2, testPats2);
        assertFalse(result);
    }

    @Test
    public void testAreFollowingPatternsThree() {
        boolean result = are.iterativeAreFollowingPatterns(testStrs, testPats);
        assertTrue(result);
    }

    @Test
    public void testAreFollowingPatternsFour() {
        boolean result = are.iterativeAreFollowingPatterns(testStrs2, testPats2);
        assertFalse(result);
    }
}