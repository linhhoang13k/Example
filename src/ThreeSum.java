Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums); // Makes the algo more efficient later on
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0) {
                // skip processing the same number
                while (i < length && nums[i] == nums[i - 1]) {
                    i++;
                }
            }


            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip processing the same number
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (nums[j] + nums[k] > -nums[i]){
                    // Efficiency: the sum of second and third nums are too big, move k back one
                    k--;
                } else {
                    // Efficiency: the sum of second and third nums are too big, move j forward one
                    j++;
                }


            }
        }


        return result;
    }
}
