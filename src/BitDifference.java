package com.ctci.chapter5;

/**
 * Created by zambro on 7/22/17.
 *
 * Given two integers n and m, find the minimum number of bits that you need to flip to make them same.
 */
public class BitDifference {

    public static int findBitDifferenceByShifting(int n, int m) {
        int difference = 0;
        for(int q = n ^ m ; q!=0 ; q >>>= 1) {
            difference += q&1;
        }
        return difference;
    }

    public static int findBitDifferenceByZeroingOutLeastSignificantBit(int n, int m) {
        int difference = 0;
        for(int q = n ^ m; q != 0; q = q & (q-1)) {
            difference++;
        }
        return difference;
    }


    public static void main(String[] args) {
        System.out.println(findBitDifferenceByShifting(3,7));
        System.out.println(findBitDifferenceByShifting(29,15));

        System.out.println(findBitDifferenceByZeroingOutLeastSignificantBit(3,7));
        System.out.println(findBitDifferenceByZeroingOutLeastSignificantBit(29,15));

    }
}
