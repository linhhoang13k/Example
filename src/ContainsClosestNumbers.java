package com.github.chen0040.codefights.hashtables;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 3/8/2017.
 *
 * Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.

 Example

 For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
 containsCloseNums(nums, k) = true.

 There are two 2s in nums, and the absolute difference between their positions is exactly 3.

 For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be

 containsCloseNums(nums, k) = false.

 The absolute difference between the positions of the two 2s is 3, which is more than k.

 Input/Output

 [time limit] 3000ms (java)
 [input] array.integer nums

 Guaranteed constraints:
 0 ≤ nums.length ≤ 55000,
 -231 - 1 ≤ nums[i] ≤ 231 - 1.

 [input] integer k

 Guaranteed constraints:
 0 ≤ k ≤ 35000.

 [output] boolean
 */
public class ContainsClosestNumbers {
   boolean containsCloseNums(int[] nums, int k) {
      Map<Integer, Integer> states = new HashMap<Integer, Integer>();
      for(int i=0; i < nums.length; ++i) {
         int num = nums[i];
         if(states.containsKey(num) && i - states.get(num) <= k) {
            return true;
         }
         states.put(num, i);
      }
      return false;
   }

}
