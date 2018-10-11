package interviewpractice.sorting;

import java.util.Arrays;

/**
 * @author benmakusha
 */
public class SortedSquaredArray {

    int[] sortedSquaredArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(array[i] * array[i]);
        }

        Arrays.sort(array);
        return array;
    }
}
