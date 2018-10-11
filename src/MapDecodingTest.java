package interviewpractice.dynamicprogrammingbasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class MapDecodingTest {

    private MapDecoding decode = new MapDecoding();

    private String inputStr = "123";
    private String inputStr2 = "0";
    private String inputStr3 = "1";
    private String inputStr4 = "1221112111122221211221221212212212111221222212122221222112122212121212221212122221211112212212211211";
    private String inputStr5 = "2871221111122261";


    @Test
    public void testMapDecodingOne() {
        int result = decode.mapDecoding(inputStr);
        assertEquals(3, result);
    }

    @Test
    public void testMapDecodingTwo() {
        int result = decode.mapDecoding(inputStr2);
        assertEquals(0, result);
    }

    @Test
    public void testMapDecodingThree() {
        int result = decode.mapDecoding(inputStr3);
        assertEquals(1, result);
    }

    @Test
    public void testMapDecodingFour() {
        int result = decode.mapDecoding(inputStr4);
        assertEquals(782204094, result);
    }

    @Test
    public void testMapDecodingFive() {
        int result = decode.mapDecoding(inputStr5);
        assertEquals(233, result);
    }
}