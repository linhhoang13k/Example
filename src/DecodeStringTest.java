package interviewpractice.heapsStacksQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class DecodeStringTest {

    private DecodeString decode = new DecodeString();

    private String inputString = "4[ab]";
    private String resultStr = "abababab";
    private String inputString2 = "2[b3[a]]";
    private String resultStr2 = "baaabaaa";
    private String inputString3 = "3[a]2[bc]";
    private String resultStr3 = "aaabcbc";
    private String inputString4 = "2[a]";
    private String resultStr4 = "aa";
    private String inputString5 = "2[2[2[2[b]]]]";
    private String resultStr5 = "bbbbbbbbbbbbbbbb";


    @Test
    public void testDecodeStringOne() {
        String result = decode.decodeString(inputString);
        assertEquals(resultStr, result);
    }

    @Test
    public void testDecodeStringTwo() {
        String result = decode.decodeString(inputString2);
        assertEquals(resultStr2, result);
    }

    @Test
    public void testDecodeStringThree() {
        String result = decode.decodeString(inputString3);
        assertEquals(resultStr3, result);
    }

    @Test
    public void testDecodeStringFour() {
        String result = decode.decodeString(inputString4);
        assertEquals(resultStr4, result);
    }

    @Test
    public void testDecodeStringFive() {
        String result = decode.decodeString(inputString5);
        assertEquals(resultStr5, result);
    }
}