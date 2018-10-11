package test;
/*
 * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

Example

For inputArray = [2, 4, 1, 0], the output should be
arrayMaximalAdjacentDifference(inputArray) = 3.

Input/Output

[time limit] 3000ms (java)
[input] array.integer inputArray

Guaranteed constraints:
3 ≤ inputArray.length ≤ 10,
-15 ≤ inputArray[i] ≤ 15.

[output] integer

The maximal absolute difference.
 */

public class arrayMaximalAdjacentDifference {
	
	int arrayMaximalAdjacentDifference(int[] inputArray) {
		int max = inputArray[0] - inputArray[1];
		
		for (int i=0;i<inputArray.length-1;i++)
		{
				if ( inputArray[i] - inputArray[i+1] > max) max =  inputArray[i] - inputArray[i+1];
				
		}
		
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 int[] input = { 2, -15, 1, 0};
	 arrayMaximalAdjacentDifference diff = new arrayMaximalAdjacentDifference();
	 System.out.println(diff.arrayMaximalAdjacentDifference(input));

	}

}
