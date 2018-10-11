package test;
/*
 * Find the leftmost digit that occurs in a given string.

Example

For inputString = "var_1__Int", the output should be
firstDigit(inputString) = '1';
For inputString = "q2q-q", the output should be
firstDigit(inputString) = '2';
For inputString = "0ss", the output should be
firstDigit(inputString) = '0'.
Input/Output

[time limit] 3000ms (java)
[input] string inputString

A string containing at least one digit.

Guaranteed constraints:
3 ≤ inputString.length ≤ 10.

[output] char


 */
public class FirstDigit {
	
	char firstDigit(String inputString) {
		
		int i = 0;
		
		while(i <= inputString.length()-1)
		{
			if(Character.isDigit(inputString.charAt(i)))
				break;
			i ++;
		}
		return inputString.charAt(i);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstDigit obj = new FirstDigit();
		System.out.println(obj.firstDigit("13!"));

	}

}
