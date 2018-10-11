package test;
/*
 * Check if all digits of the given integer are even.

Example

For n = 248622, the output should be
evenDigitsOnly(n) = true;
For n = 642386, the output should be
evenDigitsOnly(n) = false.
Input/Output

[time limit] 3000ms (java)
[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 109.

[output] boolean

true if all digits of n are even, false otherwise.


 */
public class EvenDigitsonly {
	
	boolean evenDigitsOnly(int n) {
		
		int temp = 0;
	   while(n>0)
	   {
		   temp = n%10;
		   if (temp % 2 != 0 )
			   return false;
		   n = n/10;
	   }
	   
	   return true;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenDigitsonly even = new EvenDigitsonly();
		System.out.println(even.evenDigitsOnly(22222));

	}

}
