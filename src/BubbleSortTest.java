package interviewpractice.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class BubbleSortTest {

    private BubbleSort bubble = new BubbleSort();

    private int[] inputArray = {2, 4, 1, 5};
    private int[] sortedOne = {1, 2, 4, 5};
    private int[] inputArray2 = {3, 6, 1, 5, 3, 6};
    private int[] sortedTwo = {1, 3, 3, 5, 6, 6};
    private int[] inputArray3 = {100};
    private int[] sortedThree = {100};
    private int[] inputArray4 = {2, 8, 2, 9, 3, 2, 10, 7, 3};
    private int[] sortedFour = {2, 2, 2, 3, 3, 7, 8, 9, 10};

    @Test
    public void testBubbleSortOne() {
        int[] result = bubble.bubbleSort(inputArray);
        assertArrayEquals(sortedOne, result);
    }

    @Test
    public void testBubbleSortTwo() {
        int[] result = bubble.bubbleSort(inputArray2);
        assertArrayEquals(sortedTwo, result);
    }

    @Test
    public void testBubbleSortThree() {
        int[] result = bubble.bubbleSort(inputArray3);
        assertArrayEquals(sortedThree, result);
    }

    @Test
    public void testBubbleSortFour() {
        int[] result = bubble.bubbleSort(inputArray4);
        assertArrayEquals(sortedFour, result);
    }
}