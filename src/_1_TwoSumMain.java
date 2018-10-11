/**
 * Created by Trung on 3/11/2017.
 */
package Easy;

import java.util.*;

public class _1_TwoSumMain {


    /***
     * Editorial Solution. O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumWithMap(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i =0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    public static void main(String ... args) {
        int[] arr = {2, 7 , 11, 15};
        int target = 9;

        System.out.println("Two Sum: " + twoSum(arr, target));
    }
}
