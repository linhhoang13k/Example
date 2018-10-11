package test;

/*
 * Given a string, output its longest prefix which contains only digits.

Example

For inputString="123aa1", the output should be
longestDigitsPrefix(inputString) = "123".

Input/Output

[time limit] 3000ms (java)
[input] string inputString

Guaranteed constraints:
3 ≤ inputString.length ≤ 35.

[output] string
 */

public class LongestDigitPrefix {
	
	String longestDigitsPrefix(String inputString) {
		
		int startIndex = 0;
		int max = 0;
		String maxPrefix ="" ;
		String tempHolder = "";
		while(startIndex < inputString.length()){
			if (Character.isDigit(inputString.charAt(startIndex)))
			{
				maxPrefix = maxPrefix + inputString.charAt(startIndex);
			}
			else if (Character.isAlphabetic(inputString.charAt(startIndex)))
			{
				if (maxPrefix != "" && max < Integer.parseInt(maxPrefix)){
					max  =  Integer.parseInt(maxPrefix);
					tempHolder = maxPrefix;
					maxPrefix = "";
				}
			}
			else return "";
			startIndex ++;
		}
		
		if (max == 0 && maxPrefix != ""){ return maxPrefix;}
		return tempHolder;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestDigitPrefix longest = new LongestDigitPrefix();
		System.out.println(longest.longestDigitsPrefix("01wewew234567"));

	}

}
