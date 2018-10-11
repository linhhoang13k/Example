/**
 * Created by Trung on 4/5/2017.
 */
package Easy;

public class _26_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return 1;
        else {
            int i = 0, j = 1;
            boolean notDone = true;
            while (notDone) {
                while (j < length && nums[i] == nums[j]) {
                    length--;
                    for (int a = j; a < length; a++) {
                        nums[a] = nums[a + 1];
                    }
                }
                i++;
                j++;
                if (i >= length) {
                    notDone = false;
                }
            }

        }

        return length;
    }

    public static void main(String... args) {
        int[] input = {};
        System.out.println(removeDuplicates(input));

    }
}
