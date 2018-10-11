package interviewpractice.commonTechniquesBasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class ArrayMaxConsecutiveSum2Test {

    private ArrayMaxConsecutiveSum2 arrMaxSum = new ArrayMaxConsecutiveSum2();

    private int[] inputArray = new int[] {-2, 2, 5, -11, 6};
    private int[] inputArray2 = new int[] {-3, -2, -1, -4};
    private int[] inputArray3 = new int[] {-3, 2, 1, -4};
    private int[] inputArray4 = new int[] {1, -2, 3, -4, 5, -3, 2, 2, 2};
    private int[] inputArray5 = new int[] {11, -2, 1, -4, 5, -3, 2, 2, 2};
    private int[] inputArray6 = new int[] {89, 96, 60, 10, 24, 30, 72, 40, 74, 49, 38, 87, 55, 46, 44, 14, 49, 88, 93, 11};


    @Test
    public void testArrayMaxConsecutiveSum2One() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray);
        assertEquals(7, result);
    }

    @Test
    public void testArrayMaxConsecutiveSum2Two() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray2);
        assertEquals(-1, result);
    }

    @Test
    public void testArrayMaxConsecutiveSum2Three() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray3);
        assertEquals(3, result);
    }

    @Test
    public void testArrayMaxConsecutiveSum2Four() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray4);
        assertEquals(8, result);
    }

    @Test
    public void testArrayMaxConsecutiveSum2Five() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray5);
        assertEquals(14, result);
    }

    @Test
    public void testArrayMaxConsecutiveSum2Six() {
        int result = arrMaxSum.arrayMaxConsecutiveSum2(inputArray6);
        assertEquals(1069, result);
    }
}