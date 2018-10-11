package com.ctci.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zambro on 7/19/17.
 * <p>
 * Given an int, flip a '0' in the binary representation to get the maximum sequence of 1s.
 * Return the count of 1's in such a sequence.
 */
public class FlipBitToWin {

    public static int findMaxSequenceOnes(int n) {
        List<Integer> list = getListOfZerosOnes(n);
        int maxCount = 0;

        for (int i = 0; i < list.size(); i += 2) {

            int zeroCount = list.get(i);
            int oneCount = list.get(i + 1);

            //Check with current zero count or next zero count to see if we can attain a new max count
            if ((zeroCount > 0 || i+2 < list.size()) && oneCount + 1 > maxCount)
                maxCount = oneCount + 1;

            //Check if previous zero count is just one, then merge one count with previous one count
            if (i != 0 && zeroCount == 1)
                oneCount = oneCount + list.get(i - 1) + 1;

            if (oneCount > maxCount)
                maxCount = oneCount;

        }
        return maxCount;
    }

    public static int findMaxSequenceOnesBetterMethod(int n) {
        List<Integer> list = getListOfZerosOnes(n);
        int maxCount = 0;

        for(int i=0; i<list.size(); i+=2) {
            int zeroCount = list.get(i);
            int oneCountLeft = i-1 > 0 ? list.get(i-1) : 0;
            int oneCountRight = i+1 < list.size() ? list.get(i+1) : 0;

            int oneCount = 0;
            if(zeroCount == 1) { //Merge left, flip single 0, right 1's
                oneCount = oneCountLeft + 1 + oneCountRight;
            } else if(zeroCount == 0) { //No zero's, so take max of either side - occurs only on first element
                oneCount = Math.max(oneCountLeft, oneCountRight);
            } else if(zeroCount > 0) { //More than one zero, so flip a 0 and merge with bigger sequence of 1's
                oneCount = 1 + Math.max(oneCountLeft,oneCountRight);
            }

            maxCount = Math.max(oneCount, maxCount);
        }

        return maxCount;
    }

    private static List<Integer> getListOfZerosOnes(int n) {
        List<Integer> list = new ArrayList<>();
        int lookingFor = 0, count = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != lookingFor) {
                list.add(count);
                count = 0;
                lookingFor = n & 1;
            }
            count++;
            n >>>= 1;
        }
        list.add(count);
        if (lookingFor == 0)
            list.add(0);
        return list;
    }

    public static int findMaxSequenceOnesLessSpace(int n) {
        if( ~n == 0) {
            return Integer.BYTES * 8;
        }

        int previousLength = 0;
        int currentLength = 0;
        int maxLength = 1; //All zero's as input could result in loop not executing
        while(n != 0) {
            if( (n & 1) != 0) {
                currentLength++;
            } else {
                previousLength = ((n & 2) == 0) ? 0 : currentLength;
                currentLength = 0;
            }

            maxLength = Math.max(maxLength, currentLength + previousLength + 1);
            n >>>=1;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(getListOfZerosOnes(1)); //000..00001 => [0,1,31,0]
        System.out.println(findMaxSequenceOnes(1)); //2
        System.out.println(findMaxSequenceOnesBetterMethod(1)); //2
        System.out.println(findMaxSequenceOnesLessSpace(1)); //2

        System.out.println(getListOfZerosOnes(2)); //000..00010 => [1,1,30,0]
        System.out.println(findMaxSequenceOnes(2)); //2
        System.out.println(findMaxSequenceOnesBetterMethod(2)); //2
        System.out.println(findMaxSequenceOnesLessSpace(2)); //2

        System.out.println(getListOfZerosOnes(0)); //000..0000 => [32,0]
        System.out.println(findMaxSequenceOnes(0)); //1
        System.out.println(findMaxSequenceOnesBetterMethod(0)); //1
        System.out.println(findMaxSequenceOnesLessSpace(0)); //1

        System.out.println(getListOfZerosOnes(~0)); //1111..1111 => [0,32]
        System.out.println(findMaxSequenceOnes(~0)); //32
        System.out.println(findMaxSequenceOnesBetterMethod(~0)); //32
        System.out.println(findMaxSequenceOnesLessSpace(~0)); //32

        System.out.println(getListOfZerosOnes(6)); //000..000110 => [1,2,29,0]
        System.out.println(findMaxSequenceOnes(6)); //3
        System.out.println(findMaxSequenceOnesBetterMethod(6)); //3
        System.out.println(findMaxSequenceOnesLessSpace(6)); //3

        System.out.println(getListOfZerosOnes(7)); //000..000111 => [0,3,29,0]
        System.out.println(findMaxSequenceOnes(7));//4
        System.out.println(findMaxSequenceOnesBetterMethod(7));//4
        System.out.println(findMaxSequenceOnesLessSpace(7));//4

        System.out.println(getListOfZerosOnes(9)); //000..01001 => [0,1,2,1,28,0]
        System.out.println(findMaxSequenceOnes(9)); //2
        System.out.println(findMaxSequenceOnesBetterMethod(9)); //2
        System.out.println(findMaxSequenceOnesLessSpace(9)); //2

        System.out.println(getListOfZerosOnes(1775)); //000..11011101111 => [0,4,1,3,1,2,21,0]
        System.out.println(findMaxSequenceOnes(1775)); //8
        System.out.println(findMaxSequenceOnesBetterMethod(1775)); //8
        System.out.println(findMaxSequenceOnesLessSpace(1775)); //8


    }
}
