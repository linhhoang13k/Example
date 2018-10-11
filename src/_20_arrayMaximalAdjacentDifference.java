package Arcade_Intro;

public class _20_arrayMaximalAdjacentDifference {

    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int maxDif = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            maxDif = Math.max(Math.abs(inputArray[i + 1] - inputArray[i]), maxDif);
        }
        return maxDif;
    }
}
