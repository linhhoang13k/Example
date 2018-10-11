package interviewpractice.sorting;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author benmakusha
 */
public class MergeKArraysTest {

    private MergeKArrays mergeK = new MergeKArrays();

    private int[][] inputArray = { {1,3,5}, {2,3}, {2,3,5,8} };
    private int[] sortedOne = {1, 2, 2, 3, 3, 3, 5, 5, 8};

    private int[][] inputArray2 = { {1}, {}, {1,1}, {} };
    private int[] sortedTwo = {1, 1, 1};

    private int[][] inputArray3 = { {67,83}, {1,1,5,7,9}, {-5,-2,0,1,5}, {0,0,1,5,6},
            {1,1,5,7,9}, {23,34} };
    private int[] sortedThree = {-5, -2, 0, 0, 0, 1, 1, 1, 1, 1, 1, 5,
            5, 5, 5, 6, 7, 7, 9, 9, 23, 34, 67, 83};

    @Test
    public void testMergeKArraysOne() {
        int count = 0;
        ArrayList<Integer> result = mergeK.mergeKArrays(inputArray);
        for (Integer i : result) {
            assertEquals((Integer) sortedOne[count], i);
            count++;
        }
    }

    @Test
    public void testMergeKArraysTwo() {
        int count = 0;
        ArrayList<Integer> result = mergeK.mergeKArrays(inputArray2);
        for (Integer i : result) {
            assertEquals((Integer) sortedTwo[count], i);
            count++;
        }
    }

    @Test
    public void testMergeKArraysThree() {
        int count = 0;
        ArrayList<Integer> result = mergeK.mergeKArrays(inputArray3);
        for (Integer i : result) {
            assertEquals((Integer) sortedThree[count], i);
            count++;
        }
    }
}