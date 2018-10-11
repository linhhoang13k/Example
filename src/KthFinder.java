package com.paigeruppel.heapsstacksqueues;

import java.util.PriorityQueue;

public class KthFinder {

	public int kthLargestElement(int[] nums, int k) {
	   PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
	        pq.add(nums[i]);
	    }
		int toRemove = pq.size() - k;
		for (int i = 0; i < toRemove; i++) {
			pq.remove();
		}
		return pq.peek();
	}

}
