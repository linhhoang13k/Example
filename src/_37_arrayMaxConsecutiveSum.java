package Arcade_Intro;

public class _37_arrayMaxConsecutiveSum {
    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int previousSum = 0, maxSum = 0;
        for(int i = 0; i < k; i++) maxSum += inputArray[i];
        previousSum = maxSum;

        for(int i = k; i < inputArray.length; i++){
            previousSum += inputArray[i] - inputArray[i-k];
            maxSum = Math.max(maxSum, previousSum);
        }
        return maxSum;
    }
}
