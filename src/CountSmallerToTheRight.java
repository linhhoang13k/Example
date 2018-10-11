package interviewpractice.commonTechniquesAdvanced;

/**
 * @author benmakusha
 */
public class CountSmallerToTheRight {

    int[] countSmallerToTheRight(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
            result[i] = count;
        }
        return result;
    }
}
