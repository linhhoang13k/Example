package interviewpractice.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class ClimbingStaircaseTest {

    private ClimbingStaircase stairs = new ClimbingStaircase();

    private int steps = 4;
    private int kSteps = 2;
    private int[][] stepsResult = new int[][] {{1,1,1,1},
            {1,1,2},
            {1,2,1},
            {2,1,1},
            {2,2}};

    @Test
    public void testClimbingStaircaseOne() {
        int[][] result = stairs.climbingStaircase(steps, kSteps);
        assertArrayEquals(stepsResult, result);
    }
}