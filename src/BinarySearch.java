/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsPractice;

import java.util.Scanner;

/**
 * Performs a binary search on a list of values from a whitelist file
 * @author Tom Fritz
 */
public class BinarySearch {
    
    /**
     * Finds a key within a sorted array, using the Binary Search algo.
     * @param key Search key in array of integers
     * @param a Array of integers
     * @return The position of the requested key
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
