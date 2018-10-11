package test;
/*
 * Given array of integers, find the maximal possible sum of some of its k consecutive elements.

Example

For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
arrayMaxConsecutiveSum(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:

2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
Input/Output

[time limit] 3000ms (java)
[input] array.integer inputArray

Array of positive integers.

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
1 ≤ inputArray[i] ≤ 1000.

[input] integer k

An integer (not greater than the length of inputArray).

Guaranteed constraints:
1 ≤ k ≤ inputArray.length.

[output] integer

The maximal possible sum.


 */

public class arrayMaxConsecutiveSum {
	
	int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		
		int i = 0;
		int max = 0;
		
		while (i <= inputArray.length - k)
		{
			int sum = 0;
			int count = 0;
			
			do {
				sum = sum + inputArray[i+count];
				count ++;
			}while(count < k);
			
			i++;
			if (sum > max) max = sum;
		}
		
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arrayMaxConsecutiveSum obj = new  arrayMaxConsecutiveSum();
		int[] input = {1, 3, 2, 4};
		System.out.println(obj.arrayMaxConsecutiveSum(input, 3));

	}

}
