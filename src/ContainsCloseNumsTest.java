package interviewpractice.hashTables;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class ContainsCloseNumsTest {

    private ContainsCloseNums contains = new ContainsCloseNums();

    private int[] inputArray = new int[] {0, 1, 2, 3, 5, 2};
    private int[] inputArray2 = new int[] {99, 99};
    private int[] inputArray3 = new int[] {1, 2};
    private int[] inputArray4 = new int[] {1, 0, 1, 1};


    @Test
    public void testContainsCloseNumsOne() {
        boolean result = contains.containsCloseNums(inputArray, 3);
        assertTrue(result);
    }

    @Test
    public void testContainsCloseNumsTwo() {
        boolean result = contains.containsCloseNums(inputArray2, 2);
        assertTrue(result);
    }

    @Test
    public void testContainsCloseNumsThree() {
        boolean result = contains.containsCloseNums(inputArray3, 2);
        assertFalse(result);
    }

    @Test
    public void testContainsCloseNumsFour() {
        boolean result = contains.containsCloseNums(inputArray4, 1);
        assertTrue(result);
    }
}