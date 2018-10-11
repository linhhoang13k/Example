package arcadeintro.divingdeeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
arrayMaxConsecutiveSum(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:

2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
 */
public class MaxConsecutiveSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 5, 1, 6};
        int[] input2 = {1, 3, 2, 4};
        int step = 3;

        System.out.println(maxConsecutiveSum2(input2, step));
    }

    private static int maxConsecutiveSum(int[] input, int step) {
        List<Integer> sums = new ArrayList<>();
        int index = step;
        int sum = 0; // Variable to hold sums of numbers
        int loop = 0; // Number of iteration
        while ((loop < index) && (loop + index <= input.length)) {
            for (int i = loop, j = step; i < input.length; i++) {
                if (i < (step + loop)) {
                    sum += input[i];
                    continue;
                }
                step += j;
                sums.add(sum);
                sum = input[i];
            }
            sums.add(sum);
            step = index;
            sum = 0;
            loop++;
        }
        return Collections.max(sums);
    }

    private static int maxConsecutiveSum2(int[] input, int step) {
        int sum = 0;
        int tempSum = 0;
        int start = 0;
        while (start + step <= input.length) {
            for (int i = start; i < step + start; i++) {
                tempSum += input[i];
            }
            if (tempSum > sum) {
                sum = tempSum;
            }
            tempSum = 0;
            start++;
        }
        return sum;
    }
}
