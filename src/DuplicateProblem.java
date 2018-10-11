package interview.arrays;
/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity, 
since this is what you would be asked to do during a real interview.
Given an array a that contains only numbers in the range from 1 to a.length,
find the first duplicate number for which the second occurrence has the minimal index.
In other words, if there are more than 1 duplicated numbers,
return the number for which the second occurrence has a smaller index than the second occurrence of the other number does.
If there are no such elements, return -1.
Example
For a = [2, 3, 3, 1, 5, 2], the output should be
firstDuplicate(a) = 3.
There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than than second occurrence of 2 does, so the answer is 3.

For a = [2, 4, 3, 5, 1], the output should be
firstDuplicate(a) = -1.
*/

public class DuplicateProblem {	
	static int firstDuplicate(int [] a) {
		for (int i = 0; i < a.length; i++) {
			int index = Math.abs(a[i]) - 1;
			if (a[index] >= 0) {
				a[index] = -a[index];
			} else {
				return Math.abs(a[i]);
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[] {2, 3, 3, 1, 5, 2};
		
		System.out.println("First duplicate is: " + firstDuplicate(a));
	}
}
