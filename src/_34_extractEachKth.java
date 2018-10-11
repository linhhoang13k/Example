package Arcade_Intro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _34_extractEachKth {
    int[] extractEachKth(int[] inputArray, int k) {
        // Change every k-th element to a random number
        for(int i = k-1; i < inputArray.length; i+=k){
            inputArray[i] = 123456789;
        }
        return Arrays.stream(inputArray).filter(i->i!=123456789).toArray();
    }

    int[] extractEachKthOneLiner(int[] inputArray, int k) {
        return IntStream.range(0, inputArray.length).filter(i -> ((i+1) % k) != 0).map(i -> inputArray[i]).toArray();
    }
}
