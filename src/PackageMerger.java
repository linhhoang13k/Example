package com.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 5/15/17.
 * Given a package with a weight limit limit and an array arr of item weights, implement a function getIndicesOfItemWights
 * that finds two items whose sum of weights equals the weight limit limit.
 * Your function should return a pair [i, j] of the indices of the item weights.
 * If such a pair doesn’t exist, return null.

 Analyze the time and space complexities of your solution.

 Example:

 input:  arr = [4, 6, 10, 15, 16],  lim = 21

 output: [1, 3] # since these are the indices of the
 # weights 6 and 15 whose sum equals to 21

 */
public class PackageMerger {

    public static int[] getItemWeightsOptimized(int[] arr, int limit) {
        if(arr == null)
            return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(limit - arr[i])) {
                return new int[]{i, map.get(limit-arr[i])};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getItemWeightsOptimized(new int[]{4, 6, 10, 15, 16}, 21)));
        System.out.println(Arrays.toString(getItemWeightsOptimized(new int[]{4,10,6,15,16}, 21)));
    }
}
