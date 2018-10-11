package test;
/*
 * Correct variable names consist only of Latin letters, 
 * digits and underscores and they can't start with a digit.

Check if the given string is a correct variable name.

Example

For name = "var_1__Int", the output should be
variableName(name) = true;
For name = "qq-q", the output should be
variableName(name) = false;
For name = "2w2", the output should be
variableName(name) = false.
Input/Output

[time limit] 3000ms (java)
[input] string name

Guaranteed constraints:
1 ≤ name.length ≤ 10.

[output] boolean

true if name is a correct variable name, false otherwise.
 */

public class ValidName {
	boolean variableName(String name) {
		
		   
		  if (!(
					 (name.charAt(0) >= 'a' && name.charAt(0) <= 'z') ||
					 (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') || 
					 (name.charAt(0) == '_'))) return false;
				
				for (int i=1;i<name.length();i++)
				{
						
						if (!( (name.charAt(i) >= '0' && name.charAt(i) <= '9') ||
								 (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') ||
								 (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || 
								 (name.charAt(i) == '_')))
							return false;
						
				}
				return true;}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidName valid= new ValidName();
		System.out.println(valid.variableName("va]riable0"));
	}

}
