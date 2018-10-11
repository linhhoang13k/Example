package test;

import javax.swing.text.html.HTMLDocument.Iterator;

/*
 * Given array of integers, remove each kth element from it.

Example

For inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 3, the output should be
extractEachKth(inputArray, k) = [1, 2, 4, 5, 7, 8, 10].

Input/Output

[time limit] 3000ms (java)
[input] array.integer inputArray

Guaranteed constraints:
5 ≤ inputArray.length ≤ 15,
-20 ≤ inputArray[i] ≤ 20.

[input] integer k

Guaranteed constraints:
1 ≤ k ≤ 10.

[output] array.integer

inputArray without elements k - 1, 2k - 1, 3k - 1 etc.


 */

public class ExctractEachKth {
	
int[] extractEachKth(int[] inputArray, int k) {
	
	int array[] = new int[0];
	if ( k == 1) return array;
		
	int count = 1 ;int j=0;
	int[] newArray = new int[inputArray.length - Math.abs(inputArray.length/k)];
		for (int i=0;i<inputArray.length;i++)
		{
			if (count == k)
				count = 1;
			else
			{
				newArray[j] = inputArray[i];
				count++;
				j++;
			}
		}
		
		return newArray;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ExctractEachKth obj = new ExctractEachKth();
		inputArray = obj.extractEachKth(inputArray, 1);
		for (int i=0;i<inputArray.length;i++)
		{
			System.out.println(inputArray[i]);
		}

	}

}
