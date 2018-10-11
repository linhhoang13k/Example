package InterviewPractice;

/**
 * Created by Trung on 5/19/2017.
 */

/**
 * Problem statement:
 * You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount
 * of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent houses on the
 * street have a connected security system. The system will automatically trigger an alarm if two adjacent houses are
 * broken into on the same night.
 *
 * Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the
 * maximum amount of money you can rob in one night without triggering an alarm.
 *
 * Example
 * For nums = [1, 1, 1], the output should be
 * houseRobber(nums) = 2.
 * The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.
 */
public class robHouses {

    private static int max(int a, int b) {
        return a < b ? b : a;
    }
    public static int houseRobber(int[] nums) {
        int[] max = new int[nums.length];
        if (nums.length <= 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return max(nums[0], nums[1]);
        else {
            max[0] = nums[0];
            max[1] = max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int curr = max[i - 2] + nums[i];
                int prev = max[i - 1];
                max[i] = prev < curr ? curr : prev;
            }

        }
        return max[nums.length - 1];
    }

    public static void main(String...args) {
        System.out.println(houseRobber(new int[] {1, 7, 9, 4}));
    }
}
