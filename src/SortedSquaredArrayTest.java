package interviewpractice.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class SortedSquaredArrayTest {

    private SortedSquaredArray sorted = new SortedSquaredArray();

    private int[] inputArray = {-6, -4, 1, 2, 3, 5};
    private int[] sortedOne = {1, 4, 9, 16, 25, 36};

    private int[] inputArray2 = {-49, -48, -35, -34, -29, -25, -15, -12, -3, -1};
    private int[] sortedTwo = {1, 9, 144, 225, 625, 841, 1156, 1225, 2304, 2401};

    private int[] inputArray3 = {1};
    private int[] sortedThree = {1};

    private int[] inputArray4 = {1, 4, 6, 6, 11, 12, 19, 24, 49, 50};
    private int[] sortedFour = {1, 16, 36, 36, 121, 144, 361, 576, 2401, 2500};

    private int[] inputArray5 = {-44, -42, -41, -39, -37, -36, -28, -27, -27,
            -26, -17, -12, -4, -1, 4, 6, 8, 12, 16, 16, 21, 25, 26, 26, 28,
            28, 32, 34, 34, 36, 38, 41, 45, 46, 46};
    private int[] sortedFive = {1, 16, 16, 36, 64, 144, 144, 256, 256, 289,
            441, 625, 676, 676, 676, 729, 729, 784, 784, 784, 1024, 1156,
            1156, 1296, 1296, 1369, 1444, 1521, 1681, 1681, 1764, 1936, 2025, 2116, 2116};

    @Test
    public void testSortedSquaredArrayOne() {
        int[] result = sorted.sortedSquaredArray(inputArray);
        assertArrayEquals(sortedOne, result);
    }

    @Test
    public void testSortedSquaredArrayTwo() {
        int[] result = sorted.sortedSquaredArray(inputArray2);
        assertArrayEquals(sortedTwo, result);
    }

    @Test
    public void testSortedSquaredArrayThree() {
        int[] result = sorted.sortedSquaredArray(inputArray3);
        assertArrayEquals(sortedThree, result);
    }

    @Test
    public void testSortedSquaredArrayFour() {
        int[] result = sorted.sortedSquaredArray(inputArray4);
        assertArrayEquals(sortedFour, result);
    }

    @Test
    public void testSortedSquaredArrayFive() {
        int[] result = sorted.sortedSquaredArray(inputArray5);
        assertArrayEquals(sortedFive, result);
    }
}