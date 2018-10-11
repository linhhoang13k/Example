package com.codefights.challenges;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by zambro on 6/30/17.
 */
public class AlmostRootSum {

    static int almostRootSum(int n) {
        int x = (int) Math.round(Math.sqrt(n));
        return x + x - 1;
    }


    public static void main(String[] args) {
        System.out.println(almostRootSum(10));
    }
}
