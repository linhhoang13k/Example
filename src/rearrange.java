package test;
/*
 * Given a string, replace each its character by the next one in the English alphabet (z would be replaced by a).

Example

For inputString = "crazy", the output should be
alphabeticShift(inputString) = "dsbaz".

Input/Output

[time limit] 3000ms (java)
[input] string inputString

Non-empty string consisting of lowercase English characters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 10.

[output] string

The result string after replacing all of its characters.


 */

public class rearrange {
	
	String alphabeticShift(String inputString) {
		
		for (int i=0;i<inputString.length();i++)
		{
			if ((int)(inputString.charAt(i)) >=97 && (int)(inputString.charAt(i)) <=122 ||
					(int)(inputString.charAt(i)) >=65 && (int)(inputString.charAt(i)) <=90	)
			{
				if ((int)(inputString.charAt(i)) ==122)
				{
					inputString = inputString.substring(0,i)+'a'+inputString.substring(i+1);
				}
				else if ((int)(inputString.charAt(i)) ==90)
				{
					inputString = inputString.substring(0,i)+'A'+inputString.substring(i+1);
				}
				else
				{
					inputString = inputString.substring(0,i) + (char)((int)(inputString.charAt(i))+1 )+inputString.substring(i+1);
				}
			}
		}
		
		return inputString;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rearrange a = new rearrange();
		System.out.println(a.alphabeticShift("sruthi"));
	}

}
