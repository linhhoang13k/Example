package test;
/*
 * Given two strings, find the number of common characters between them.

Example

For s1 = "aabcc" and s2 = "adcaa", the output should be
commonCharacterCount(s1, s2) = 3.

Strings have 3 common characters - 2 "a"s and 1 "c".

Input/Output

[time limit] 3000ms (java)
[input] string s1

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
3 ≤ s1.length ≤ 15.

[input] string s2

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
4 ≤ s2.length ≤ 15.

[output] integer


 */
public class commonCharecterCount {
	
	int commonCharacterCount(String s1, String s2) {
		
		int commonCount = 0;
		
		for (int i=0; i<s1.length();i++)
		{
			for(int j=0;j<s2.length();j++)
			{
				if (s2.charAt(j) != '0' && s1.charAt(i) == s2.charAt(j))
				{
					commonCount++;
					if (j+1 < s2.length())
					s2 = s2.substring(0,j)+"0"+s2.substring(j+1, s2.length());
					else
						s2 = s2.substring(0,j)+"0";
					break;
				}
			}
		}
		return commonCount;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commonCharecterCount c = new commonCharecterCount();
		System.out.println(c.commonCharacterCount("zzzzz", "aaaaz"));

	}

}
