package com.ctci.chapter1;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by zambro on 2/20/17.
 */
public class UniqueStringValidator {

    public static boolean isUniqueStringUsingCharArray(String str) {
        int[] characterBitVector = new int[256];
        for(char c: str.toCharArray()) {
            int asciiValue = (int) c;
            if(characterBitVector[asciiValue] != 0) {
                return false;
            } else {
                characterBitVector[asciiValue]++;
            }
        }

        return true;
    }

    public static boolean isUniqueString(String str) {
        char[] inputCharacters = str.toCharArray();
        Arrays.sort(inputCharacters);
        for(int i=1; i<inputCharacters.length; i++) {
            if(inputCharacters[i] == inputCharacters[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueStringUsingBitVector(String str) {
        int bitVector = 0;
        for(int i=0;i<str.length();i++) {
            int bitValue = str.charAt(i) - 'a';
            if((bitVector & (1<<bitValue)) > 0) {
                return false;
            } else {
                bitVector = bitVector | (1<<bitValue);
            }
        }
        return true;
    }

    public static boolean isUniqueStringUsingBitSet(String str) {
        BitSet bitVector = new BitSet(256);
        for(int i=0;i<str.length();i++) {
            int asciiValue = (int) str.charAt(i);
            if(bitVector.get(asciiValue)) {
                return false;
            } else {
                bitVector.set(asciiValue);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueStringUsingCharArray("hello"));
        System.out.println(isUniqueStringUsingCharArray("helo"));
        System.out.println();
        System.out.println(isUniqueString("hello"));
        System.out.println(isUniqueString("helo"));
        System.out.println();
        System.out.println(isUniqueStringUsingBitVector("worldw"));
        System.out.println(isUniqueStringUsingBitVector("world"));
        System.out.println();
        System.out.println(isUniqueStringUsingBitSet("hello"));
        System.out.println(isUniqueStringUsingBitSet("helo"));
    }
}
