package test;

/*
 * Given a string, find out if its characters can be rearranged to form a palindrome.

Example

For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

[time limit] 3000ms (java)
[input] string inputString

A string consisting of lowercase English letters.

Guaranteed constraints:
4 ≤ inputString.length ≤ 50.

[output] boolean

true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.


 */
public class palindromeRearranging {

	boolean palindromeRearranging(String inputString) {

		int count = 0;

		for (int i = 0; i < inputString.length(); i++) {
			
			for (int j = i + 1; j < inputString.length(); j++) {
				if (inputString.charAt(i) != '0') {
					if (inputString.charAt(i) == inputString.charAt(j)) {
						if(j < inputString.length()-1)
						inputString = inputString.substring(0, j) + "0" + inputString.substring(j + 1);
						else
							inputString = inputString.substring(0, j) + "0";	
						inputString = inputString.substring(0,i)+"0"+inputString.substring(i+1);
					}
				}
				
			}
		}
		
		for (int i=0;i<inputString.length();i++)
		{
			if(inputString.charAt(i) != '0')
				count++;
			if (count == 2) return false;
		}

		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "abbabb";
		palindromeRearranging poly = new palindromeRearranging();
		System.out.println(poly.palindromeRearranging(str));

	}

}
