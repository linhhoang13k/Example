package interviewpractice.dynamicprogrammingbasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class ClimbingStairsTest {

    private ClimbingStairs climb = new ClimbingStairs();

    @Test
    public void testClimbingStairsOne() {
        int result = climb.climbingStairs(1);
        assertEquals(1, result);
    }

    @Test
    public void testClimbingStairsTwo() {
        int result = climb.climbingStairs(26);
        assertEquals(196418, result);
    }

    @Test
    public void testClimbingStairsThree() {
        int result = climb.climbingStairs(38);
        assertEquals(63245986, result);
    }

    @Test
    public void testClimbingStairsFour() {
        int result = climb.climbingStairs(13);
        assertEquals(377, result);
    }

    @Test
    public void testClimbingStairsFive() {
        int result = climb.climbingStairs(20);
        assertEquals(10946, result);
    }

    @Test
    public void testClimbingStairsSix() {
        int result = climb.climbingStairs(42);
        assertEquals(433494437, result);
    }
}