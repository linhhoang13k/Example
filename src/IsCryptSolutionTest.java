package interviewpractice.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class IsCryptSolutionTest {

    private IsCryptSolution ist = new IsCryptSolution();

    private String[] testStrs = new String[] {"SEND", "MORE", "MONEY"};
    private char[][] testSolution = new char[][] { {'O', '0'}, {'M', '1'}, {'Y', '2'},
            {'E', '5'}, {'N', '6'}, {'D', '7'}, {'R', '8'}, {'S', '9'} };

    private String[] testStrsTwo = new String[] {"TEN", "TWO", "ONE"};
    private char[][] testSolutionTwo = new char[][] { {'O', '1'}, {'T', '0'}, {'W', '9'},
            {'E', '5'}, {'N', '4'} };

    @Test
    public void testIsCryptSolutionOne() {
        boolean result = ist.isCryptSolution(testStrs, testSolution);
        assertTrue(result);
    }

    @Test
    public void testIsCryptSolutionTwo() {
        boolean result = ist.isCryptSolution(testStrsTwo, testSolutionTwo);
        assertFalse(result);
    }
}