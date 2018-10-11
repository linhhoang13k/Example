package com.ctci.misc.examples;

import java.util.Arrays;

/**
 * Created by zambro on 3/31/17.
 * Given an array of 0,1,2 rearrange the elements so that all 1's follow 0's and all 2's follow 1's
 */
public class ArraySorter012s {

    public static void sort(int[] arr) {
        if(arr != null) {
            if(arr.length >= 3) {
                int start = 0, end = arr.length - 1, reader = 1;

                while(reader <= end && reader >= start) {
                    if(arr[reader] == 2) {
                        arr[reader] = arr[end];
                        arr[end] = 2;
                        end--;
                    } else if(arr[reader] == 0) {
                        arr[reader] = arr[start];
                        arr[start] = 0;
                        start++;
                    } else {
                        reader++;
                    }
                }

            } else if(arr.length == 2) {
               if(arr[0] > arr[1]) {
                   int temp = arr[1];
                   arr[1] = arr[0];
                   arr[0] = temp;
               }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,0,0,2,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
