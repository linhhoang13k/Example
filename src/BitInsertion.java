package com.ctci.chapter5;

/**
 * Created by zambro on 7/16/17.
 */
public class BitInsertion {

    static int insertNumber(int n, int m, int i, int j) {
        //Find m size - most significant bit
        int size = findMostSignificantSetBit(m);
        //Do i = j - m.size;
        int index = j - size;

        int leftMask = ~0 << index;
        int rightMask = ~0 >>> (31-j);
        int mask = ~(leftMask & rightMask);

        int clearedN = n & mask;

        //Shift m to left by index
        m = m <<index;

        //n OR m;
        return clearedN | m;
    }

    static int findMostSignificantSetBit(int m) {
        int pos = 31;
        int mask = 1 <<31;
        while(pos>=0){
            if((m & mask) != 0)
                return pos;
            pos--;
            mask >>>=1;
        }

        return pos;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insertNumber(1024,19,2,6)));
        System.out.println(Integer.toBinaryString(insertNumber(1456,19,2,8)));
    }
}
