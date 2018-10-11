package interviewpractice.heapsStacksQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class KthLargestElementTest {

    private KthLargestElement kth = new KthLargestElement();

    private int[] inputArray = new int[] {7, 6, 5, 4, 3, 2, 1};

    @Test
    public void testKthLargestElementOne() {
        int result = kth.kthLargestElement(inputArray, 2);
        assertEquals(6, result);
    }
}