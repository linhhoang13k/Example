package interviewpractice.commonTechniquesBasic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author benmakusha
 */
public class MinSubstringWithAllCharsTest {

    private MinSubstringWithAllChars min = new MinSubstringWithAllChars();

    private String inputStr = "adobecodebanc";
    private String inputStrChar = "abc";
    private String inputStr2 = "zqyvbfeiee";
    private String inputStrChar2 = "ze";
    private String inputStr3 = "";
    private String inputStrChar3 = "";

    @Test
    public void testMinSubstringWithAllCharsOne() {
        String result = min.minSubstringWithAllChars(inputStr, inputStrChar);
        assertEquals("banc", result);
    }

    @Test
    public void  testMinSubstringWithAllCharsTwo() {
        String result = min.minSubstringWithAllChars(inputStr2, inputStrChar2);
        assertEquals("zqyvbfe", result);
    }

    @Test
    public void  testMinSubstringWithAllCharsThree() {
        String result = min.minSubstringWithAllChars(inputStr3, inputStrChar3);
        assertEquals("", result);
    }
}