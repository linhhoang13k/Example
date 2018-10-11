package Arcade_Intro;

import java.util.Arrays;

public class _16_areSimilar {
    boolean areSimilar(int[] a, int[] b) {
        if (Arrays.equals(a, b)) return true;

        int numberOfDiversity = 0, a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                numberOfDiversity++;
                if (numberOfDiversity == 1) {
                    a1 = a[i];
                    b1 = b[i];
                }
                if (numberOfDiversity == 2) {
                    a2 = a[i];
                    b2 = b[i];
                }
            }
        }
        return numberOfDiversity == 0 || numberOfDiversity == 2 && a1 == b2 && a2 == b1;
    }
}
