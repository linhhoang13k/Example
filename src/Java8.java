package com.codefights.arcade.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by zambro on 5/5/17.
 */
public class Java8 {

    /**
     * Given an integer size, return array of length size filled with 1s.
     * https://codefights.com/arcade/code-arcade/list-forest-edge/gmZFbpR9cirL3Jpf2
     *
     * @param size
     * @return
     */
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Arrays.setAll(array, i -> 1);
        return array;
    }

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     * <p>
     * Example
     * <p>
     * For inputArray = [1, 2, 1], elemToReplace = 1 and substitutionElem = 3, the output should be
     * arrayReplace(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
     *
     * @param a
     * @param e
     * @param s
     * @return
     */
    public static int[] arrayReplace(int[] a, int e, int s) {
        return Arrays.stream(a)
                .map(i -> i == e ? s : i).toArray();
    }

    /**
     * Reversing an array can be a tough task, especially for a novice programmer. Mary just started coding, so she would like to start with something basic at first. Instead of reversing the array entirely, she wants to swap just its first and last elements.
     * <p>
     * Given an array arr, swap its first and last elements and return the resulting array.
     *
     * @param arr
     * @return
     */
    public static int[] firstReverseTry(int[] arr) {
        if (arr != null && arr.length > 0) {
            int temp = arr[0];
            arr[0] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    /**
     * Given two arrays of integers a and b, obtain the array formed by the elements of a followed by the elements of b.
     * <p>
     * Example
     * <p>
     * For a = [2, 2, 1] and b = [10, 11], the output should be
     * concatenateArrays(a, b) = [2, 2, 1, 10, 11].
     */
    public static int[] concatenateArrays(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

    /**
     * Remove a part of a given array between given 0-based indexes l and r (inclusive).
     * <p>
     * Example
     * <p>
     * For inputArray = [2, 3, 2, 3, 4, 5], l = 2 and r = 4, the output should be
     * removeArrayPart(inputArray, l, r) = [2, 3, 5].
     */
    public static int[] removeArrayPart(int[] inputArray, int l, int r) {
        return IntStream.range(0,inputArray.length).filter(i->i<l||i>r).map(i->inputArray[i]).toArray();
    }

    /**
     * Given array arr, your task is to find its middle, and, if it consists of two elements, replace those elements with the value of middle. Return the resulting array as the answer.
     * For arr = [7, 2, 2, 5, 10, 7], the output should be
     replaceMiddle(arr) = [7, 2, 7, 10, 7].

     The middle consists of two elements, 2 and 5. These two elements should be replaced with their sum, i.e. 7.

     For arr = [-5, -5, 10], the output should be
     replaceMiddle(arr) = [-5, -5, 10].
     */
    public static int[] replaceMiddle(int[] arr) {
        if(arr == null || arr.length % 2 == 1)
            return arr;
        return IntStream.range(0,arr.length).filter(i->i!=arr.length/2).map(i->{
            if(i==(arr.length/2) -1){
                return (arr[i]+arr[i+1]);
            } else {
                return arr[i];
            }
        }).toArray();
    }

//    public static int makeArrayConsecutive2(int[] statues) {
//        List<Integer> list = new ArrayList<>();
//    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeArrayPart(new int[]{2, 3, 2, 3, 4, 5}, 2, 4)));
        System.out.println(Arrays.toString(replaceMiddle(new int[]{7, 2, 2, 5, 10, 7})));
    }

}
