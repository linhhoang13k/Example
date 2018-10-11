package com.ctci.chapter1;

/**
 * Created by zambro on 2/25/17.
 */
public class StringSpaceReplacer {

    public static char[] replaceSpaces(char[] arr, int length) {
        int start = length - 1;
        int end = arr.length - 1;

        for(;start >= 0; start--, end--) {
            if(arr[start] == ' ') {
                arr[end--] = '0';
                arr[end--] = '2';
                arr[end] = '%';
            } else {
                arr[end] = arr[start];
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        char[] arr = "Mr John Smith    ".toCharArray();
        int length = 13;
        System.out.println("Before: "+new String(arr));
        System.out.println("After: "+new String(replaceSpaces(arr, length)));

    }
}
