package com.paigeruppel.interviewpractice.dynamicprogramming.basic;

public class NonAdjacentMaximizer {
    public int houseRobber(int[] nums) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i % 2 == 0) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
        }
        return (oddSum >= evenSum) ? oddSum : evenSum;
    }

}
