package test;
/*
 * Let's define digit degree of some positive integer as the number of times we need to replace this number with the sum of its digits until we get to a one digit number.

Given an integer, find its digit degree.

Example

For n = 5, the output should be
digitDegree(n) = 0;
For n = 100, the output should be
digitDegree(n) = 1.
1 + 0 + 0 = 1.
For n = 91, the output should be
digitDegree(n) = 2.
9 + 1 = 10 -> 1 + 0 = 1.
Input/Output

[time limit] 3000ms (java)
[input] integer n

Guaranteed constraints:
5 ≤ n ≤ 109.

[output] integer


 */
public class DigitDegree {
	
	int digitDegree(int n) {
		
		int degree = 0;
		
		if (findNumberOfDigits(n) == 0)
		{
			return degree;
		}
		else
		{
			return findDegreeUsingRecursion(n, degree);
		}
			
		

	}



	private int findDegreeUsingRecursion(int n, int degree) {
		
		int newNumber = 0;
		while(n > 0)
		{
			newNumber = newNumber + n%10;
			n = n/10;
		}
		
		if (findNumberOfDigits(newNumber) == 0)
		{
			degree ++;
			return degree;
		}
		else
		{
			degree ++;
			return findDegreeUsingRecursion(n, degree);
		}
	}



	private int findNumberOfDigits(int n) {
		int temp = 0;
		while(n >= 10)
		{
			n = n/10;
			temp ++;
		}
		return temp;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitDegree degree = new DigitDegree();
		System.out.println(degree.digitDegree(100));
	}

}
