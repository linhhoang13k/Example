package com.ctci.chapter5;

/**
 * Created by zambro on 7/22/17.
 *
 * Swap the even and odd bits in an integer.
 *
 * eg: 1101011 is 01010111
 */
public class PariwiseSwap {

    public static int swapEvenOddBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        //Shift even positions to left by AND with 01010101010101010101010101010101, then shift to left by 1
        int leftEven = (n & 0x55555555) << 1;
        //Shift odd positions to right by AND with 10101010101010101010101010101010, then shift to right by 1
        int rightOdd = (n & 0xaaaaaaaa) >>> 1;
        return leftEven | rightOdd;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(swapEvenOddBits(116)));
    }
}
