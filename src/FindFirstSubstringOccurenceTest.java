package interviewpractice.strings;

import interviewpractice.arrays.FirstNotRepeatingCharacter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class FindFirstSubstringOccurenceTest {

    private FindFirstSubstringOccurence first = new FindFirstSubstringOccurence();

    private String testString = "CodefightsIsAwesome";
    private String firstSubStr = "IA";
    private String secSubStr = "IsA";

    @Test
    public void testFindFirstSubstringOccurrenceOne() {
        int result = first.findFirstSubstringOccurrence(testString, firstSubStr);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testFindFirstSubstringOccurenceTwo() {
        int result = first.findFirstSubstringOccurrence(testString, secSubStr);
        Assert.assertEquals(10, result);
    }
}