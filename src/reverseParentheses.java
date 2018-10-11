package test;
/*
 * You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets. It is guaranteed that the parentheses in s form a regular bracket sequence.

Your task is to reverse the strings contained in each pair of matching parentheses, starting from the innermost pair. The results string should not contain any parentheses.

Example

For string s = "a(bc)de", the output should be
reverseParentheses(s) = "acbde".

Input/Output

[time limit] 3000ms (java)
[input] string s

A string consisting of English letters, punctuation marks, whitespace characters and brackets. It is guaranteed that parentheses form a regular bracket sequence.

Constraints:
5 ≤ s.length ≤ 55.

[output] string


 */
public class reverseParentheses {
	
	String reverseParenthese(String s) {
		
		int i= s.indexOf('(');
		int j= s.indexOf(')');
		
		String str = s.substring(i+1, j);
		
		String rev = "";
		
		for (int k = str.length()-1 ; k>=0 ; k--)
		{
			rev = rev + str.charAt(k);
		}
		
		return s.substring(0,i)+rev+s.substring(j+1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseParentheses s = new reverseParentheses();
		System.out.println(s.reverseParenthese("ade()"));
	}

}
