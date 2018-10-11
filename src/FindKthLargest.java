package com.pramp;

import java.util.Arrays;

/**
 * Created by zambro on 4/10/17.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example, given [3,2,1,5,6,4] and k = 2, return 5.

 Note: You may assume k is always valid, 1 ≤ k ≤ array's length.


 */
public class FindKthLargest {

    public static int getKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    public static void main(String[] args) {
        int[] arr = {12,3,44,23,4};
        System.out.println(getKthLargest(arr, 1));
        System.out.println(getKthLargest(arr, 2));
    }
}
