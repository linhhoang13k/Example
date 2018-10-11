package test;
/*
 * Given a string, find the number of different characters in it.

Example

For s = "cabca", the output should be
differentSymbolsNaive(s) = 3.

There are 3 different characters a, b and c.

Input/Output

[time limit] 3000ms (java)
[input] string s

A string of lowercase latin letters.

Guaranteed constraints:
3 ≤ s.length ≤ 15.

[output] integer
 */
public class differentSymbolsNaive {
	
	int differentSymbolsNaive(String s) {
		
		String newString ="";
		
		for (int i=0;i<s.length();i++)
		{
			
			if( !newString.contains(""+s.charAt(i)))
				newString = newString + ""+ s.charAt(i);
		}
		
		return newString.length();

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		differentSymbolsNaive obj = new differentSymbolsNaive();
		System.out.println(obj.differentSymbolsNaive("cabca"));

	}

}
