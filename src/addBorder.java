package test;
/*
 * Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example

For

picture = ["abc",
           "ded"]
the output should be

addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]
Input/Output

[time limit] 3000ms (java)
[input] array.string picture

A non-empty array of non-empty equal-length strings.

Guaranteed constraints:
1 ≤ picture.length ≤ 5,
1 ≤ picture[i].length ≤ 5.

[output] array.string

The same matrix of characters, framed with a border of asterisks of width 1.


 */
public class addBorder {
	
	String[] addBorder(String[] picture) {
		
		int i = picture.length;
		int j= picture[0].length();
		String[] newone = new String[i+2];
		String start = "";
		
		for (int k = 0 ;k<j+2;k++)
		{
			start = start+"*";
		}
		
		for (int l=0;l<newone.length;l++)
		{
			if (l==0 || l==newone.length-1)
			newone[l]  = start;
			else
				newone[l] = "*"+picture[l-1] +"*";
			
		}
		
		
		
		return newone;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

String[] picture = {"abc",
           "ded"};

addBorder add= new addBorder();

picture = add.addBorder(picture);

for (int i = 0;i<picture.length;i++)
{
	System.out.println(picture[i]);
}

	}

}
