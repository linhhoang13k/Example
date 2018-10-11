package interviewpractice.commonTechniquesBasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class SumInRangeTest {

    public SumInRange sum = new SumInRange();

    private int[] inputArray = new int[] {3, 0, -2, 6, -3, 2};
    private int[][] inputArrRange = new int[][] { {0,2}, {2,5}, {0,5} };

    private int[] inputArray2 = new int[] {-1000};
    private int[][] inputArrRange2 = new int[][] { {0,0} };

    @Test
    public void testSumInRangeOne() {
        int result = sum.sumInRange(inputArray, inputArrRange);
        assertEquals(10, result);
    }

    @Test
    public void testSumInRangeTwo() {
        int result = sum.sumInRange(inputArray2, inputArrRange2);
        assertEquals(999999007, result);
    }
}