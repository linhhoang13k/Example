/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int subSum = 0;
        int subMax =nums[0];
        for(int i=0; i<nums.length; i++){
            subSum +=nums[i];
            if(subSum>subMax){
                subMax = subSum;
            }
            if(subSum<0){
                subSum = 0;
            }
        }
        return subMax;
    }
}