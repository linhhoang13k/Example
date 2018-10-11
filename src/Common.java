package interview_practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @author BinhPT7
 */
public class Common {
    /**
     * You have two integer arrays, a and b, and an integer target value v.
     * Determine whether there is a pair of numbers, where one number is taken from a and the other from b, that can be added together to get a sum of v.
     * Return true if such a pair exists, otherwise return false.
     * Example:
     * <p>
     * For a = [1, 2, 3], b = [10, 20, 30, 40], and v = 42, the output should be
     * sumOfTwo(a, b, v) = true.
     *
     * @return true if there are two elements from a and b which add up to v, and false otherwise.
     */
    boolean sumOfTwo(int[] a, int[] b, int v) {
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.stream(a).boxed().collect(Collectors.toSet()));
        for (int b_ele : b) {
            if (setA.contains(v - b_ele)) return true;
        }
        return false;
    }

    /**
     * You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based).
     * Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each query,
     * then add all of the sums for all the queries together.
     * Return that number modulo 109 + 7.
     * <p>
     * Example
     * <p>
     * For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
     * sumInRange(nums, queries) = 10.
     * <p>
     * The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
     *
     * @return An integer that is the sum of all of the sums gotten from querying nums, taken modulo 109 + 7
     */
    public int sumInRange(int[] nums, int[][] queries) {
        long sum = nums[0];
        long[] nums_long = new long[nums.length];
        nums_long[0] = sum;
        // recount nums from element i to sum of elements to i
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            nums_long[i] = sum;
        }
        sum = 0L;
        for (int[] q : queries) {
            sum += (nums_long[q[1]] - (q[0] == 0 ? 0 : nums_long[q[0] - 1]));
        }
        return (int) Math.floorMod(sum, (long) (Math.pow(10, 9) + 7));
    }

    /**
     * Given an array of integers, find the maximum possible sum you can get from one of its contiguous subarrays. The subarray from which this sum comes must contain at least 1 element.
     * <p>
     * Example
     * <p>
     * For inputArray = [-2, 2, 5, -11, 6], the output should be
     * arrayMaxConsecutiveSum2(inputArray) = 7.
     * <p>
     * The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7
     */
    int arrayMaxConsecutiveSum2(int[] inputArray) {
        int res = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            tempSum += inputArray[i];
            if (tempSum > res) {
                res = tempSum;
            }
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return res;
    }

}
