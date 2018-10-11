package org.matt.codefights.arcade.intro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheJourneyBeginsTest {

    TheJourneyBegins theJourneyBegins;

    @Before
    public void setUp() {
        theJourneyBegins = new TheJourneyBegins();
    }

    @Test
    public void addTest1() {
        assertEquals(3, theJourneyBegins.add(1, 2));
    }

    @Test
    public void addTest2() {
        assertEquals(1000, theJourneyBegins.add(0, 1000));
    }

    @Test
    public void centuryFromYearTest1() {
        assertEquals(20, theJourneyBegins.centuryFromYear(1905));
    }

    @Test
    public void centuryFromYearTest2() {
        assertEquals(17, theJourneyBegins.centuryFromYear(1700));
    }

    @Test
    public void centuryFromYearTest3() {
        assertEquals(20, theJourneyBegins.centuryFromYear(1988));
    }

    @Test
    public void centuryFromYearTest4() {
        assertEquals(20, theJourneyBegins.centuryFromYear(2000));
    }

    @Test
    public void centuryFromYearTest5() {
        assertEquals(21, theJourneyBegins.centuryFromYear(2001));
    }

    @Test
    public void centuryFromYearTest6() { assertEquals(2, theJourneyBegins.centuryFromYear(200)); }

    @Test
    public void centuryFromYearTest7() {
        assertEquals(4, theJourneyBegins.centuryFromYear(374));
    }

    @Test
    public void centuryFromYearTest8() {
        assertEquals(1, theJourneyBegins.centuryFromYear(45));
    }

    @Test
    public void centuryFromYearTest9() {
        assertEquals(1, theJourneyBegins.centuryFromYear(8));
    }

    @Test
    public void checkPalindromeTest1() {
        assertEquals(true, theJourneyBegins.checkPalindrome("aabaa"));
    }

    @Test
    public void checkPalindromeTest2() {
        assertEquals(false, theJourneyBegins.checkPalindrome("abac"));
    }

    @Test
    public void checkPalindromeTest3() {
        assertEquals(true, theJourneyBegins.checkPalindrome("a"));
    }

    @Test
    public void checkPalindromeTest4() {
        assertEquals(false, theJourneyBegins.checkPalindrome("az"));
    }

    @Test
    public void checkPalindromeTest5() {
        assertEquals(true, theJourneyBegins.checkPalindrome("abacaba"));
    }

    @Test
    public void checkPalindromeTest6() {
        assertEquals(true, theJourneyBegins.checkPalindrome("z"));
    }

    @Test
    public void checkPalindromeTest7() {
        assertEquals(false, theJourneyBegins.checkPalindrome("aaabaaaa"));
    }

    @Test
    public void checkPalindromeTest8() {
        assertEquals(false, theJourneyBegins.checkPalindrome("zzzazzazz"));
    }

    @Test
    public void checkPalindromeTest9() {
        assertEquals(true, theJourneyBegins.checkPalindrome("hlbeeykoqqqqokyeeblh"));
    }

    @Test
    public void checkPalindromeTest10() {
        assertEquals(true, theJourneyBegins.checkPalindrome("hlbeeykoqqqokyeeblh"));
    }
}
