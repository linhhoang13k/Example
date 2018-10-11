
/*Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky 
 * if the sum of the first half of the digits is equal to the sum of the second half.

Given a ticket number n, determine if it's lucky or not.

Example

For n = 1230, the output should be
isLucky(n) = true;
For n = 239017, the output should be
isLucky(n) = false.
Input/Output

[time limit] 3000ms (java)
[input] integer n

A ticket number represented as a positive integer with an even number of digits.

Guaranteed constraints:
10 ≤ n < 106.

[output] boolean

true if n is a lucky ticket number, false otherwise.

*/

package test;

public class isLucky {
	
	boolean isLucky(int n) {
		
		
		
		String str = Integer.toString(n);
		int half = str.length() /2;
		
		int sum1 = 0 ; int sum2 = 0;
		
		int i = 0;
		while (i <half)
		{
			sum1 = sum1+Integer.parseInt(""+str.charAt(i));
			i++;
		}
		
		
		while (half   < str.length())
		{
			sum2 = sum2+Integer.parseInt(""+str.charAt(half));
			half++;
		}
		
		return sum1 == sum2;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		isLucky lucky = new isLucky();
		System.out.println(lucky.isLucky(123123));

	}

}
