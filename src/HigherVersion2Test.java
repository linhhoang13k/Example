package interviewpractice.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class HigherVersion2Test {

    private HigherVersion2 high = new HigherVersion2();

    private String inputVersionOne = "1.2.2";
    private String inputVersionTwo = "1.2.0";

    private String inputVersionOne2 = "1.0.5";
    private String inputVersionTwo2 = "1.00.05";

    private String inputVersionOne3 = "1";
    private String inputVersionTwo3 = "0";

    private String inputVersionOne4 = "1.0";
    private String inputVersionTwo4 = "1.10";

    private String inputVersionOne5 = "1.10";
    private String inputVersionTwo5 = "1.0";

    private String inputVersionOne6 = "1.2";
    private String inputVersionTwo6 = "1.10";

    private String inputVersionOne7 = "0.9.9.9.9.9.9.9.9.9.9.9.9";
    private String inputVersionTwo7 = "1.0.0.0.0.0.0.0.0.0.0.0.0";

    private String inputVersionOne8 = "1.00000000000000000000001";
    private String inputVersionTwo8 = "1.10";

    private String inputVersionOne9 = "1.1";
    private String inputVersionTwo9 = "1.01";

    private String inputVersionOne10 = "1.0.1";
    private String inputVersionTwo10 = "1.01.0";

    @Test
    public void testHigherVersion2One() {
        int result = high.higherVersion2(inputVersionOne, inputVersionTwo);
        assertEquals(1, result);
    }

    @Test
    public void testHigherVersion2Two() {
        int result = high.higherVersion2(inputVersionOne2, inputVersionTwo2);
        assertEquals(0, result);
    }

    @Test
    public void testHigherVersion2Three() {
        int result = high.higherVersion2(inputVersionOne3, inputVersionTwo3);
        assertEquals(1, result);
    }

    @Test
    public void testHigherVersion2Four() {
        int result = high.higherVersion2(inputVersionOne4, inputVersionTwo4);
        assertEquals(-1, result);
    }

    @Test
    public void testHigherVersion2Five() {
        int result = high.higherVersion2(inputVersionOne5, inputVersionTwo5);
        assertEquals(1, result);
    }

    @Test
    public void testHigherVersion2Six() {
        int result = high.higherVersion2(inputVersionOne6, inputVersionTwo6);
        assertEquals(-1, result);
    }

    @Test
    public void testHigherVersion2Seven() {
        int result = high.higherVersion2(inputVersionOne7, inputVersionTwo7);
        assertEquals(-1, result);
    }

    @Test
    public void testHigherVersion2Eight() {
        int result = high.higherVersion2(inputVersionOne8, inputVersionTwo8);
        assertEquals(-1, result);
    }

    @Test
    public void testHigherVersion2Nine() {
        int result = high.higherVersion2(inputVersionOne9, inputVersionTwo9);
        assertEquals(0, result);
    }

    @Test
    public void testHigherVersion2Ten() {
        int result = high.higherVersion2(inputVersionOne10, inputVersionTwo10);
        assertEquals(-1, result);
    }
}