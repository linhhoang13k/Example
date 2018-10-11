package test;
/*
 * Given a sorted array of integers a, find such an integer x that the value of

abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)
is the smallest possible (here abs denotes the absolute value).
If there are several possible answers, output the smallest one.

Example

For a = [2, 4, 7], the output should be
absoluteValuesSumMinimization(a) = 4.

Input/Output

[time limit] 3000ms (java)
[input] array.integer a

A non-empty array of integers, sorted in ascending order.

Guaranteed constraints:
1 ≤ a.length ≤ 200,
-106 ≤ a[i] ≤ 106.

[output] integer


 */
public class absoluteValuesSumMinimization {
	
	int absoluteValuesSumMinimization(int[] a) {
		
		int temp[] = new int[a.length];
		int count = 0;
		/*
		if (a.length == 1) return a[0];
		
		while(count<a.length){
		int aa= 0;
		for (int i=0;i<a.length;i++)
		{
		aa = aa + a[i]-a[count];	
		}
		temp[count] = a[count];
		if(aa < 0) return temp[count-1];
		count++;
		}*/
		
		System.out.println(a.length);
		if (a.length%2 == 0)
			return a[a.length/2-1];
		else return a[(a.length+1)/2-1];

	}
	
	public static void main(String args[])
	{
		absoluteValuesSumMinimization a = new absoluteValuesSumMinimization();
		int a1[] = {-10, -10, -10, -10, -10, -9, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
		System.out.println(a.absoluteValuesSumMinimization(a1));
	}

}
