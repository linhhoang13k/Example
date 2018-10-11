package interviewpractice.counting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class StringPermutationsTest {

    private StringPermutations str = new StringPermutations();

    private String inputStr = "ABC";
    private String[] inputResult = new String[] {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};

    private String inputStr2 = "ABA";
    private String[] inputResult2 = new String[] {"AAB", "ABA", "BAA"};

    @Test
    public void testStringPermutationsOne() {
        String[] result = str.stringPermutations(inputStr);
        assertArrayEquals(inputResult, result);
    }

    @Test
    public void testStringPermutationsTwo() {
        String[] result = str.stringPermutations(inputStr2);
        assertArrayEquals(inputResult2, result);
    }

}