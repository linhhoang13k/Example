/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = 0;
        int length = nums.length;
        Arrays.sort(nums);

        if (length <= 3) {

            for (int n: nums) {
                answer += n;
            }

            return answer;
        }

        answer = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && i < length - 3) {
                if (nums[i] == nums[i - 1]) {   // Prevent duplication
                    i++;
                }
            }

            int sum = 0;    // sums each new set of three numbers
            int j = i + 1;  // tracks second number
            int k = length - 1;  // tracks third number

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(answer - target)) {
                    answer = sum;
                }
                // to make the sum as close to the target as possible
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return answer;
    }
}
