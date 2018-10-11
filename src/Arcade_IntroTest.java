import org.junit.Test;

import static org.junit.Assert.*;

public class Arcade_IntroTest {
    private Arcade_Intro ai;

    @org.junit.Before
    public void setUp() throws Exception {
        ai = new Arcade_Intro();
    }

    @org.junit.Test
    public void add() {
        assertEquals(7, ai.add(2, 5));
        assertEquals(100, ai.add(0, 100));
        assertEquals(46, ai.add(72, -26));
    }

    @Test
    public void add2() {
        assertEquals(5, ai.add2(5));
        assertEquals(0, ai.add2(0, 0));
        assertEquals(11, ai.add2(2, 5, 4));
    }

    @org.junit.Test
    public void centuryFromYear() {
        assertEquals(20, ai.centuryFromYear(1905));
        assertEquals(17, ai.centuryFromYear(1700));
        assertEquals(1, ai.centuryFromYear(8));
    }

    @org.junit.Test
    public void checkPalindrome() {
        assertFalse(ai.checkPalindrome("abac"));
        assertTrue(ai.checkPalindrome("abacaba"));
        assertFalse(ai.checkPalindrome("zzzazzazz"));
        assertTrue(ai.checkPalindrome("z"));
    }


    @Test
    public void adjacentElementsProduct() {
        assertEquals(0, ai.adjacentElementsProduct(new int[]{1, 0, 1, 0, 1000}));
        assertEquals(30, ai.adjacentElementsProduct(new int[]{5, 6, -4, 2, 3, 2, -23}));
        assertEquals(-12, ai.adjacentElementsProduct(new int[]{-23, 4, -3, 8, -12}));
    }

    @Test
    public void shapeArea() {
        assertEquals(5, ai.shapeArea(2));
        assertEquals(41, ai.shapeArea(5));
    }

    @Test
    public void makeArrayConsecutive2() {
        assertEquals(0, ai.makeArrayConsecutive2(new int[]{1}));
        assertEquals(0, ai.makeArrayConsecutive2(new int[]{5, 4, 6}));
        assertEquals(2, ai.makeArrayConsecutive2(new int[]{0, 3}));
    }

    @Test
    public void almostIncreasingSequence() {
        assertTrue(ai.almostIncreasingSequence(new int[]{3, 5, 67, 98, 3}));
        assertTrue(ai.almostIncreasingSequence(new int[]{0, -2, 5, 6}));
        assertFalse(ai.almostIncreasingSequence(new int[]{1, 4, 10, 4, 2}));
        assertFalse(ai.almostIncreasingSequence(new int[]{1, 1, 1, 2, 3}));
    }

    @Test
    public void matrixElementsSum() {
        assertEquals(0, ai.matrixElementsSum(new int[][]{{0}}));
        assertEquals(18, ai.matrixElementsSum(new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        }));
        assertEquals(9, ai.matrixElementsSum(new int[][]{
                {1, 1, 1, 0},
                {0, 5, 0, 1},
                {2, 1, 3, 10}
        }));
    }

    @Test
    public void allLongestStrings() {
        assertArrayEquals(new String[]{"zzzzzz", "abcdef", "aaaaaa"},
                ai.allLongestStrings(new String[]{"a",
                        "abc",
                        "cbd",
                        "zzzzzz",
                        "a",
                        "abcdef",
                        "asasa",
                        "aaaaaa"}));
        assertArrayEquals(new String[]{"aa"}, new String[]{"aa"});
    }

    @Test
    public void commonCharacterCount() {
        assertEquals(1, ai.commonCharacterCount("a", "aaa"));
        assertEquals(0, ai.commonCharacterCount("a", "b"));
        assertEquals(3, ai.commonCharacterCount("abca", "xyzbac"));
    }

    @Test
    public void isLucky() {
        assertTrue(ai.isLucky(123321));
        assertFalse(ai.isLucky(100000));
        assertFalse(ai.isLucky(239017));
    }

    @Test
    public void sortByHeight() {
        assertArrayEquals(new int[]{-1, 150, 160, 170, -1, -1, 180, 190},
                ai.sortByHeight(new int[]{-1, 150, 190, 170, -1, -1, 160, 180}));
        assertArrayEquals(new int[]{2, 2, 4, 9, 11, 16},
                ai.sortByHeight(new int[]{4, 2, 9, 11, 2, 16}));
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1},
                ai.sortByHeight(new int[]{-1, -1, -1, -1, -1}));
    }

    @Test
    public void reverseParentheses() {
        assertEquals("apmnolkjihgfedcbq", ai.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        assertEquals("The god quick nworb xof jumps over the lazy", ai.reverseParentheses("The ((quick (brown) (fox) jumps over the lazy) dog)"));

    }

    @Test
    public void alternatingSums() {
        assertArrayEquals(new int[]{80, 0}, ai.alternatingSums(new int[]{80}));
        assertArrayEquals(new int[]{100, 50}, ai.alternatingSums(new int[]{100, 50}));
        assertArrayEquals(new int[]{180, 105}, ai.alternatingSums(new int[]{50, 60, 60, 45, 70}));
    }

    @Test
    public void addBorder() {
        assertArrayEquals(new String[]{"***", "*a*", "***"}, ai.addBorder(new String[]{"a"}));
        assertArrayEquals(new String[]{"*****", "*abc*", "*ded*", "*****"}, ai.addBorder(new String[]{"abc", "ded"}));
        assertArrayEquals(new String[]{"*******", "*wzy***", "*******"}, ai.addBorder(new String[]{"wzy**"}));
    }

    @Test
    public void areSimilar() {
        assertTrue((ai.areSimilar(new int[]{1, 2, 3}, new int[]{2, 1, 3})));
        assertFalse((ai.areSimilar(new int[]{1, 1, 4}, new int[]{1, 2, 3})));
    }

    @Test
    public void arrayChange() {
        assertEquals(3, ai.arrayChange(new int[]{1, 1, 1}));
        assertEquals(13, ai.arrayChange(new int[]{2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15}));
    }

    @Test
    public void palindromeRearranging() {
        assertFalse(ai.palindromeRearranging("abca"));
        assertFalse(ai.palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"));
        assertTrue(ai.palindromeRearranging("aabb"));
        assertTrue(ai.palindromeRearranging("zyyzzzzz"));
    }

    @Test
    public void areEquallyStrong() {
        assertFalse(ai.areEquallyStrong(20, 15, 5, 20));
        assertFalse(ai.areEquallyStrong(5, 5, 10, 10));
        assertTrue(ai.areEquallyStrong(10, 20, 10, 20));
        assertTrue(ai.areEquallyStrong(10, 5, 5, 10));
    }

    @Test
    public void arrayMaximalAdjacentDifference() {
        assertEquals(7, ai.arrayMaximalAdjacentDifference(new int[]{-1, 4, 10, 3, -2}));
        assertEquals(0, ai.arrayMaximalAdjacentDifference(new int[]{1, 1, 1, 1}));
        assertEquals(3, ai.arrayMaximalAdjacentDifference(new int[]{2, 4, 1, 0}));
    }

}

