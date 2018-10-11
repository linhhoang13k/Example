package com.sleepsoft.challenges;

import java.util.Arrays;

/**
 * Created by agermenos on 9/20/16.
 */
public class ClosestSequence {
    int closestSequence2(int[] a, int[] b) {
        int currentChamp = 0;
        int challenger = 0;
        for (int aX=a.length-1; aX>=0; aX--){
            for (int bX=aX; bX<(b.length-a.length+aX+1); bX++){
                challenger+= Math.abs(b[bX]-a[aX]);
                System.out.print (b[bX] + " ");
            }
            System.out.println();
            currentChamp=(aX==0?challenger:currentChamp<challenger?currentChamp:challenger);
        }
        return currentChamp;
    }

    private void log(String text){
        System.out.println(text);
    }

    public void test(int[]a, int[]b, int result){
        log("a: " + Arrays.toString(a));
        log("b: " + Arrays.toString(b));
        log ("Expected value: " + result);
        log("Value: " + closestSequence2(a,b) + "\n");
    }

    public static void main(String args[]){
        ClosestSequence cs = new ClosestSequence();
        cs.test(new int[]{1, 2, 6}, new int[]{0, 1, 3, 4, 5}, 2);
        cs.test(new int[]{1, 2, 1, 2, 1, 2}, new int[]{3, 0, 0, 3, 0, 3, 3, 0, 0}, 7);
        cs.test(new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 0);
        cs.test(new int[]{13, 5, 3, -1, -9, 20, 5, -17, 20, -11, -6, 1, 17, 18, 20, -6, 11, 12, 3, -8}, new int[]{1, 1, -18, -3, -9, 16, 5, 13, -2, 4, -9, -16, -20, 13, -3, 10, 20, -5, -20, 2}, 270);
    }

}
