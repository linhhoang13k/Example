package com.pramp;

import java.util.Arrays;

/**
 * Created by zambro on 5/15/17.
 * Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.

 Solve without using division and analyze your solution’s time and space complexities.

 Examples:

 input:  arr = [8, 10, 2]
 output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

 input:  arr = [2, 7, 3, 4]
 output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]

 answer = [1, 1*2, 1*2*7, 1*2*7*3]
 answer = [1, 1*2, 1*2*7, 1*2*7*3*1]
 answer = [1, 1*2, 1*2*7*4, 1*2*7*3*1]
 answer = [1, 1*2*7*4, 1*2*7*4, 1*2*7*3*1]
 answer = [1*2*7*4, 1*2*7*4, 1*2*7*4, 1*2*7*3*1]

 */
public class ArrayOfArrayProducts {

    public static int[] arrayProducts(int[] arr) {
        if(arr == null)
            return null;

        if(arr.length == 1)
            return arr;
        int[] answer = new int[arr.length];
        int product = 1;
        for(int i=0;i<arr.length;i++) {
            answer[i] = product;
            product *= arr[i];
        }

        product = 1;
        for(int i=arr.length-1;i>=0;i--) {
            answer[i] *= product;
            product *= arr[i];
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(arrayProducts(new int[]{2,7,3,4})));
        System.out.println(Arrays.toString(arrayProducts(new int[]{8,10,2})));
        System.out.println(Arrays.toString(arrayProducts(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(arrayProducts(new int[]{10})));
        System.out.println(Arrays.toString(arrayProducts(new int[]{10,20})));
    }
}
