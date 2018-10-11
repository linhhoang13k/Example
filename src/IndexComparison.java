package com.paigeruppel.interviewpractice.hashtables;

import java.util.HashMap;
import java.util.Map;

public class IndexComparison {

	public boolean containsCloseNums(int[] nums, int k) {
		Map<Integer, Integer> indexValue = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (indexValue.containsKey(num)) {
				int position = indexValue.get(num);
				if (Math.abs(i - position) <= k) {
					return true;
				}
			}
			indexValue.put(num, i);
		}
		return false;
	}

}
