package Arcade_Intro;

import java.util.Arrays;

public class _25_arrayReplace {
    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        return Arrays.stream(inputArray).map(item -> item == elemToReplace ? substitutionElem : item).toArray();
    }
}
