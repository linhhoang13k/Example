package interviewpractice.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author benmakusha
 */
public class QuickSortTest {

    private QuickSort quick = new QuickSort();

    private int[] inputArray = {5, 2, 1, 7, 5, 3, 2, 3};
    private int[] sortedOne = {1, 2, 5, 7, 5, 3, 2, 3};
    private int[] inputArray2 = {5, 2, 1, 7, 5, 3, 2, 3};
    private int[] sortedTwo = {1, 2, 2, 3, 3, 5, 5, 7};
    private int[] inputArray3 = {1, 100, 1, 100, 1};
    private int[] sortedThree = {1, 100, 1, 100, 1};
    private int[] inputArray4 = {5, 2, 1, 7, 5, 3, 2, 3};
    private int[] sortedFour = {5, 2, 1, 7, 5, 3, 2, 3};

    @Test
    public void testQuickSortOne() {
        int[] result = quick.quickSort(inputArray, 0, 3);
        assertArrayEquals(sortedOne, result);
    }

    @Test
    public void testQuickSortTwo() {
        int[] result = quick.quickSort(inputArray2, 0, 7);
        assertArrayEquals(sortedTwo, result);
    }

    @Test
    public void testQuickSortThree() {
        int[] result = quick.quickSort(inputArray3, 0, 1);
        assertArrayEquals(sortedThree, result);
    }

    @Test
    public void testQuickSortFour() {
        int[] result = quick.quickSort(inputArray4, 3, 3);
        assertArrayEquals(sortedFour, result);
    }
}