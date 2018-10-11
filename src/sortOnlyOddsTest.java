import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class sortOnlyOddsTest {

    private SortOnlyOdds sut;

    @Test
    public void EmptyArray() {
        int[] givenArray = new int[]{};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{}), Arrays.toString(result));

    }

    @Test
    public void onlyOneElementArray() {
        int[] givenArray = new int[]{5};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{5}), Arrays.toString(result));

    }

    @Test
    public void onlyEvenElementsArray() {
        int[] givenArray = new int[]{8, 2, 6, 12, 18};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{8, 2, 6, 12, 18}), Arrays.toString(result));

    }

    @Test
    public void onlyOddsElementsArray() {
        int[] givenArray = new int[]{11, 7, 3, 5, 13};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{3, 5, 7, 11, 13}), Arrays.toString(result));

    }

    @Test
    public void zeroIsAnEvenNumber() {
        int[] givenArray = new int[]{777, 117, 23, 0, 0};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{23, 117, 777, 0, 0}), Arrays.toString(result));

    }

    @Test
    public void twoSortTwoLeft() {
        int[] givenArray = new int[]{8, 13, 7, 2};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{8, 7, 13, 2}), Arrays.toString(result));

    }

    @Test
    public void threeSortThreeLeft() {
        int[] givenArray = new int[]{5, 3, 2, 8, 1, 4};
        sut = new SortOnlyOdds(givenArray);
        int[] result = sut.sortIgnoringOdds(givenArray);
        assertEquals(Arrays.toString(new int[]{1, 3, 2, 8, 5, 4}), Arrays.toString(result));

    }
}
