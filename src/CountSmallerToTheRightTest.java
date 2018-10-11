package interviewpractice.commonTechniquesAdvanced;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class CountSmallerToTheRightTest {

    private CountSmallerToTheRight count = new CountSmallerToTheRight();

    private int[] inputArray = new int[] {3, 8, 4, 1};
    private int[] resultArray = new int[] {1, 2, 1, 0};

    private int[] inputArray2 = new int[] {};
    private int[] resultArray2 = new int[] {};

    private int[] inputArray3 = new int[] {5, 3, 2, 4, 4, 35, 1, 14, 38, 35, 2};
    private int[] resultArray3 = new int[] {6, 3, 1, 2, 2, 3, 0, 1, 2, 1, 0};

    @Test
    public void testCountSmallerToTheRightOne() {
        int[] result = count.countSmallerToTheRight(inputArray);
        assertArrayEquals(resultArray, result);
    }

    @Test
    public void testCountSmallerToTheRightTwo() {
        int[] result = count.countSmallerToTheRight(inputArray2);
        assertArrayEquals(resultArray2, result);
    }

    @Test
    public void testCountSmallerToTheRightThree() {
        int[] result = count.countSmallerToTheRight(inputArray3);
        assertArrayEquals(resultArray3, result);
    }
}