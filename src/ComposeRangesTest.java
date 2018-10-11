package interviewpractice.dynamicprogrammingbasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class ComposeRangesTest {

    private ComposeRanges composeRanges = new ComposeRanges();

    private int[] inputArray = new int[] {-1, 0, 1, 2, 6, 7, 9};
    private String[] resultArray = new String[] {"-1->2", "6->7", "9"};

    private int[] inputArray2 = new int[] {-1};
    private String[] resultArray2 = new String[] {"-1"};

    private int[] inputArray3 = new int[] {5, 8};
    private String[] resultArray3 = new String[] {"5", "8"};

    private int[] inputArray4 = new int[] {0, 1, 9};
    private String[] resultArray4 = new String[] {"0->1", "9"};

    @Test
    public void testComposeRangesOne() {
        String[] result = composeRanges.composeRanges(inputArray);
        assertArrayEquals(resultArray, result);
    }

    @Test
    public void testComposeRangesTwo() {
        String[] result = composeRanges.composeRanges(inputArray2);
        assertArrayEquals(resultArray2, result);
    }

    @Test
    public void testComposeRangesThree() {
        String[] result = composeRanges.composeRanges(inputArray3);
        assertArrayEquals(resultArray3, result);
    }

    @Test
    public void testComposeRangesFour() {
        String[] result = composeRanges.composeRanges(inputArray4);
        assertArrayEquals(resultArray4, result);
    }
}