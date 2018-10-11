package Arcade_Intro;

public class _04_adjacentElementsProduct {
    int adjacentElementsProduct(int[] inputArray) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < inputArray.length -1; i++) {
            answer = inputArray[i] * inputArray[i + 1] > answer ? inputArray[i] * inputArray[i + 1] : answer;
        }
        return answer;
    }
}
