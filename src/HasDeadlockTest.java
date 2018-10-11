package interviewpractice.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class HasDeadlockTest {

    private HasDeadlock has = new HasDeadlock();

    private int[][] inputArray = new int[][]{ {1}, {2}, {3,4}, {4}, {0} };
    private int[][] inputArray2 = new int[][] { {1,2,3}, {2,3}, {3}, {} };
    private int[][] inputArray3 = new int[][] {{2}, {0,2}, {}, {4,2}, {2,3} };
    private int[][] inputArray4 = new int[][] { {} };
    private int[][] inputArray5 = new int[][] { {2,3,5}, {0,2,5,4,3}, {3}, {5},
            {3,5}, {} };

    @Test
    public void testHasDeadlockOne() {
        boolean result = has.hasDeadlock(inputArray);
        assertTrue(result);
    }

    @Test
    public void testHasDeadlockTwo() {
        boolean result = has.hasDeadlock(inputArray2);
        assertFalse(result);
    }

    @Test
    public void testHasDeadlockThree() {
        boolean result = has.hasDeadlock(inputArray3);
        assertTrue(result);
    }

    @Test
    public void testHasDeadlockFour() {
        boolean result = has.hasDeadlock(inputArray4);
        assertFalse(result);
    }

    @Test
    public void testHasDeadlockFive() {
        boolean result = has.hasDeadlock(inputArray5);
        assertFalse(result);
    }
}