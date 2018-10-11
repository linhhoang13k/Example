package javaFights.missingNumbers;

import java.util.Arrays;

/**
 You are supposed to label a bunch of boxes with numbers from 0 to n, and all the labels are stored in the array arr. Unfortunately one of the labels is missing. Your task is to find it.

 Example

 For arr = [3, 1, 0], the output should be
 missingNumber(arr) = 2.

 Input/Output

 [time limit] 3000ms (java)
 [input] array.integer arr

 An unsorted array consisting of different integers from 0 to n inclusive, with only one of them missing.

 Constraints:
 1 ≤ arr.length ≤ 1000,
 0 ≤ arr[i] ≤ arr.length.

 [output] integer

 The missing number.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 1, 0};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int x = 0;
        for(int a : arr){
            if(x != a) break;
            x++;
        }
        return x;
    }

}
