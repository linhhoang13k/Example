package exercise37;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveSumCalculator {

	/**
	 * Given array of integers, find the maximal possible sum of some of its k
	 * consecutive elements.
	 */

	public int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		int sumHolder = 0;
		int maxSum = 0;
		// potential sum sets
		for (int i = 0; i <= inputArray.length - k; i++) {
			for (int add = 0; add < k; add++) {
				sumHolder += inputArray[i + add];
				if (add == k - 1 && sumHolder > maxSum) {
					maxSum = sumHolder;
				}
			}
			sumHolder = 0;
		}

		return maxSum;
	}


}
