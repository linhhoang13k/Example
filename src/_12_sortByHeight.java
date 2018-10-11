package Arcade_Intro;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Arrays;

public class _12_sortByHeight {
    int[] sortByHeight(int[] a) {
        // Stream + Filter + Sort
        int[] solution = Arrays.stream(a).filter(item -> item != -1).toArray();
        Arrays.sort(solution);

        // Replace elements != -1 with the elements from the sorted array.
        int solIndex = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] != -1){
                a[i] = solution[solIndex++];
            }
        }
        return a;
    }
}
