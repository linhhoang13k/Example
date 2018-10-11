package com.codefight.challanges;

import java.util.Arrays;
/**
 * 
 * @author muralimanohar
 *
 *The first thing to do is to check that an array,arr, is of pairwise relatively prime integers.
 *
 *Given an array, arr , check if it is in its entirety relatively prime.
 *
 *Example
 *
 *For arr = [2, 3, 11], the output should be breakDown1(arr) = true;
 *For arr = [2, 4, 5], the output should be breakDown1(arr) = false.
 *
 *Input/Output
 *
 *[execution time limit] 3 seconds (java)
 *
 *[input] array.integer arr
 *
 *An array of integers.
 *
 *Guaranteed constraints:
 *arr.length = 3,
 *2 ≤ arr[i] < 3 · 105.
 *
 *[output] boolean
 *
 *Return true if the sequence consists of relatively prime numbers, else return false.
 */
public class BreakDown {

	public static void main(String[] args) {
		int a[] = {721, 927, 2};
		breakDown1(a);
	}

	static boolean breakDown1(int[] arr) {
	    int one = 0;
	    int two = 0;

	    Arrays.sort(arr);

	    one = arr[1] % arr[0];
	    two = arr[2] % arr[0];
	    if((one == 0) || (two == 0) ){
	        return false;
	    }
	    return true;
	}


}
