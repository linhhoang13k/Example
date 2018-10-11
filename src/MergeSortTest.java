package interviewpractice.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class MergeSortTest {

    private MergeSort merge = new MergeSort();

    private int[] inputArray = {2, 4, 1, 5};
    private int[] sortedOne = {1, 2, 4, 5};
    private int[] inputArray2 = {3, 6, 1, 5, 3, 6};
    private int[] sortedTwo = {1, 3, 3, 5, 6, 6};
    private int[] inputArray3 = {100};
    private int[] sortedThree = {100};
    private int[] inputArray4 = {2, 8, 2, 9, 3, 2, 10, 7, 3};
    private int[] sortedFour = {2, 2, 2, 3, 3, 7, 8, 9, 10};

    @Test
    public void testMergeSortOne() {
        int[] result = merge.mergeSort(inputArray);
        assertArrayEquals(sortedOne, result);
    }

    @Test
    public void testMergeSortTwo() {
        int[] result = merge.mergeSort(inputArray2);
        assertArrayEquals(sortedTwo, result);
    }

    @Test
    public void testMergeSortThree() {
        int[] result = merge.mergeSort(inputArray3);
        assertArrayEquals(sortedThree, result);
    }

    @Test
    public void testMergeSortFour() {
        int[] result = merge.mergeSort(inputArray4);
        assertArrayEquals(sortedFour, result);
    }
}