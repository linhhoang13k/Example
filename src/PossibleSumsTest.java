package interviewpractice.hashTables;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class PossibleSumsTest {

    private PossibleSums pos = new PossibleSums();

    private int[] inputArray = new int[] {10, 50, 100};
    private int[] quantityArray = new int[] {1, 2, 1};
    private int[] inputArray2 = new int[] {10, 50, 100, 500};
    private int[] quantityArray2 = new int[] {5, 3, 2, 2};
    private int[] inputArray3 = new int[] {1};
    private int[] quantityArray3 = new int[] {5};
    private int[] inputArray4 = new int[] {1, 1};
    private int[] quantityArray4 = new int[] {2, 3};
    private int[] inputArray5 = new int[] {1, 2};
    private int[] quantityArray5 = new int[] {5000, 2};

    @Test
    public void testPossibleSumsOne() {
        int result = pos.possibleSums(inputArray, quantityArray);
        assertEquals(9, result);
    }

    @Test
    public void testPossibleSumsTwo() {
        int result = pos.possibleSums(inputArray2, quantityArray2);
        assertEquals(122, result);
    }

    @Test
    public void testPossibleSumsThree() {
        int result = pos.possibleSums(inputArray3, quantityArray3);
        assertEquals(5, result);
    }

    @Test
    public void testPossibleSumsFour() {
        int result = pos.possibleSums(inputArray4, quantityArray4);
        assertEquals(5, result);
    }

    @Test
    public void testPossibleSumsFive() {
        int result = pos.possibleSums(inputArray5, quantityArray5);
        assertEquals(5004, result);
    }
}