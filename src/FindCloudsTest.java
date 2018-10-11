package interviewpractice.heapsStacksQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class FindCloudsTest {

    private FindClouds findClouds = new FindClouds();

    private char[][] inputArray = new char[][] {
            {'0','1','1','0','1'},
            {'0','1','1','1','1'},
            {'0','0','0','0','1'},
            {'1','0','0','1','1'}};
    private int testResult = 2;

    @Test
    public void testCountCloudsOne() {
        int result = findClouds.countClouds(inputArray);
        assertEquals(testResult, result);
    }
}