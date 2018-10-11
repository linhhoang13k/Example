/*
Challenge Discription:

You are given a chain of digits. The first element of the chain is the initial offset.
Your task is to calculate the total offset, where offset is the sum of differences 
between two consecutive digits.

Example

For chain = "14839", the output should be
offsets(chain) = 6.

The total offset is calculated as follows:
1 + ((8 - 4) + (3 - 8) + (9 - 3)) = 1 + (4 - 5 + 6) = 6.

Input/Output

[time limit] 3000ms (java)
[input] string chain

A string of digits.

Constraints:
5 ≤ chain.length ≤ 1000.

[output] integer

The total offset.

*/


/**
	@author Casey Langford
	Date: 9/2/16
	Challenge: https://codefights.com/challenge/HTPdz8fy2hiZGAXbJ/main

	This solution solved all the standard and hidden tests. The below solution was shortened
	for the submission.
*/

public class Offsets{
	public static void main(String[] args){
		Offsets test = new Offsets();
		
		// Test1: Expected output: 6
		System.out.println("TOTAL OFFSET = " + test.offsets("14839"));

		// Test2: Expected output: -3
		System.out.println("TOTAL OFFSET = " + test.offsets("05992644492")); 
	}

	int offsets(String chain){
		
		int offset = 0;
		
		for(int i = chain.length() - 1; i > 1; i--){
			offset += (int)chain.charAt(i) - (int)chain.charAt(i - 1);
		}
		// Couldn't figure this one out. For some reason this was not giving me a
		// correct int when getting the char, so i had to subtract 48
		return offset + chain.charAt(0) - 48;
	}
}