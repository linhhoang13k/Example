/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Majority Element {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        
        for(int i=1; i<nums.length; i++){
            if(count == 0){
                count++;
                major = nums[i];
            }else if(nums[i]==major){
                count++;
            }else{
                count--;
            }
        }
      return major;
    }
}