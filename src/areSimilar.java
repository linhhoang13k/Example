package test;
/*
 * Two arrays are called similar if one can be obtained 
 * 
 * from another by swapping at most one pair of elements in one of the arrays.

Given two arrays, check whether they are similar.

Example

For A = [1, 2, 3] and B = [1, 2, 3], the output should be
areSimilar(A, B) = true.

The arrays are equal, no need to swap any elements.

For A = [1, 2, 3] and B = [2, 1, 3], the output should be
areSimilar(A, B) = true.

We can obtain B from A by swapping 2 and 1 in B.

For A = [1, 2, 2] and B = [2, 1, 1], the output should be
areSimilar(A, B) = false.

Any swap of any two elements either in A or in B won't make A and B equal.

Input/Output

[time limit] 3000ms (java)
[input] array.integer A

Array of integers.

Guaranteed constraints:
3 ≤ A.length ≤ 105,
1 ≤ A[i] ≤ 1000.

[input] array.integer B

Array of integers of the same length as A.

Guaranteed constraints:
B.length = A.length,
1 ≤ B[i] ≤ 1000.

[output] boolean

true if A and B are similar, false otherwise.


 */

public class areSimilar {
	
	boolean areSimilar(int[] A, int[] B) {
		
		if (A.length == B.length)
		{
			Boolean check = false;
			for (int i = 0; i<A.length;i++)
			{
				for (int j=0;j<B.length;j++)
				{
					if (A[i] == B[j]) {check = true;break;}
				}
				if(check == true) check = false;
				else return false;
			}
			int b = aretheyEqual(A,B);
			
			if (b >2) return false;
			else return true;
			
		}
		return false;

	}

	private int aretheyEqual(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int swap = 0;
		for (int i = 0;i<a.length;i++)
		{
			if (a[i] != b[i]) swap ++;
			
		}
		
		return swap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = { 9, 2, 3,4,5} ; int B[] = {3, 2, 1,4,5};
		areSimilar are = new areSimilar();
		System.out.println(are.areSimilar(a, B));

	}

}
