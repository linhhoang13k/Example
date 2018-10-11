package interviewpractice.commonTechniquesBasic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author benmakusha
 */
public class FindLongestSubarrayBySumTest {

    private FindLongestSubarrayBySum find = new FindLongestSubarrayBySum();

    private int[] inputArray = new int[] {1, 2, 3, 7, 5};
    private int[] firstResArr = new int[] {2, 4};
    private int[] inputArray2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] secResArr = new int[] {1, 5};
    private int[] inputArray3 = new int[] {3};
    private int[] thirdResArr = new int[] {1, 1};

    @Test
    public void testFindLongestSubarrayBySumOne() {
        int[] result = find.findLongestSubarrayBySum(12, inputArray);
        Assert.assertArrayEquals(firstResArr, result);
    }

    @Test
    public void testFindLongestSubarrayBySumTwo() {
        int[] result = find.findLongestSubarrayBySum(15, inputArray2);
        Assert.assertArrayEquals(secResArr, result);
    }

    @Test
    public void testFindLongestSubarrayBySumThree() {
        int[] result = find.findLongestSubarrayBySum(3, inputArray3);
        Assert.assertArrayEquals(thirdResArr, result);
    }
}