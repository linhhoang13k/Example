package interviewpractice.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class SinglePointOfFailureTest {

    private SinglePointOfFailure single = new SinglePointOfFailure();

    private int[][] connections = new int[][] {{0,1},
            {1,0}};
    private int[][] connections2 = new int[][] {{0,1,1},
            {1,0,1},
            {1,1,0}};
    private int[][] connections3 = new int[][] {{0,1,1,0,0,0,0},
            {1,0,1,0,0,0,0},
            {1,1,0,0,0,0,1},
            {0,0,0,0,1,1,1},
            {0,0,0,1,0,1,0},
            {0,0,0,1,1,0,0},
            {0,0,1,1,0,0,0}};


    @Test
    public void testSinglePointOfFailureOne() {
        int result = single.singlePointOfFailure(connections);
        assertEquals(1, result);
    }

    @Test
    public void testSinglePointOfFailureTwo() {
        int result = single.singlePointOfFailure(connections2);
        assertEquals(0, result);
    }

    @Test
    public void testSinglePointOfFailureThree() {
        int result = single.singlePointOfFailure(connections3);
        assertEquals(2, result);
    }
}