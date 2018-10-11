package com.ctci.chapter5;

/**
 * Created by zambro on 7/16/17.
 */
public class BasicBitOperators {

    public static boolean getBit(int num, int pos) {
        return (num & 1<<pos) != 0;
    }

    public static int findMostSignificantSetBit(int num) {
        int pos = 31;
        int mask = 1 << 31;
        while(pos >= 0) {
            if((num & mask) != 0)
                return pos;
            mask >>>= 1;
            pos--;
        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getBit(3,0));
        System.out.println(getBit(2,0));
        System.out.println(getBit(4,2));
        System.out.println(getBit(8,3));

        System.out.println(findMostSignificantSetBit(3));
        System.out.println(findMostSignificantSetBit(2));
        System.out.println(findMostSignificantSetBit(4));
        System.out.println(findMostSignificantSetBit(8));
        System.out.println(findMostSignificantSetBit(12));
        System.out.println(findMostSignificantSetBit(16));
    }
}
