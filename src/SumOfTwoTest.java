import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class sumOfTwoTest {

    private SumOfTwo sut;

    @Test
    public void oneElementsArray() {
        int[] firstArray = new int[]{3};
        int[] secondArray = new int[]{3};
        int targetValue = 6;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(true, result);
    }

    @Test
    public void oneEmptyArray() {
        int[] firstArray = new int[]{};
        int[] secondArray = new int[]{1};
        int targetValue = 4;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(false, result);
    }

    @Test
    public void bothEmptyArrays() {
        int[] firstArray = new int[]{};
        int[] secondArray = new int[]{};
        int targetValue = 4;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(false, result);
    }

    @Test
    public void isTrue1() {
        int[] firstArray = new int[]{10, 1, 5, 3};
        int[] secondArray = new int[]{100, 6, 3, 1, 5};
        int targetValue = 4;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(true, result);
    }

    @Test
    public void isTrue2() {
        int[] firstArray = new int[]{1, 4, 3, 6, 1, 1, 0, 1, 6, 5};
        int[] secondArray = new int[]{9, 5, 6, 9, 0, 1, 2, 1, 6, 10};
        int targetValue = 8;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(true, result);
    }

    @Test
    public void isFalse1() {
        int[] firstArray = new int[]{10, 1, 5, 3, 8};
        int[] secondArray = new int[]{100, 6, 3, 1, 5};
        int targetValue = 74;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(false, result);
    }

    @Test
    public void isFalse2() {
        int[] firstArray = new int[]{11, 4, 3, 6, 10, 1, 0, 1, 6, 5};
        int[] secondArray = new int[]{9, 5, 6, 9, 0, 1, 2, 1, 6, 10};
        int targetValue = 81;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(false, result);
    }

    @Test
    public void onlyNegativeNumberButTrue() {
        int[] firstArray = new int[]{-11, -7, -4, -9};
        int[] secondArray = new int[]{-4, -6, -3, -2};
        int targetValue = -10;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(true, result);
    }

    @Test
    public void onlyNegativeNumberAndFalse() {
        int[] firstArray = new int[]{-1, -7, -4, -9};
        int[] secondArray = new int[]{-4, -6, -3, -2};
        int targetValue = 10;
        sut = new SumOfTwo(firstArray, secondArray, targetValue);
        boolean result = sut.sumEqualsTarget(firstArray, secondArray, targetValue);
        assertEquals(false, result);
    }
}
