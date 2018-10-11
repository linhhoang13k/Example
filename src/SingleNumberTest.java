package interviewpractice.bits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class SingleNumberTest {

    private SingleNumber single = new SingleNumber();

    private int[] testArray = new int[] {2, 2, 1};
    private int testArrayResult = 1;

    @Test
    public void testSingleNumberOne() {
        int result = single.singleNumber(testArray);
        assertEquals(testArrayResult, result);
    }

}