/**
 * 
 */
package com.ab.cf.array;

/**
 * @author berenyia
 *
 */
public class CryptSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char[] solutionChar(String s, char[][] solution) {
		char[] c1 = new char[s.length()];
		// convert string 1 to number string
		for (int i = 0; i < s.length(); i++) {
			char cryptChar = s.charAt(i);
			for (int j = 0; j < solution.length; j++) {
				char solutionChar = solution[j][0];
				if (cryptChar == solutionChar) {
					c1[i] = solution[j][1];
					continue;
				}
			}
		}
		return c1;
	}

	public boolean isCryptSolution(String[] crypt, char[][] solution) {
		// test if first digits are zero


		// convert string 1 to number string
		char[] c1 = solutionChar(crypt[0], solution);
		if (c1[0] == '0' && c1.length > 1)
			return false;

		// convert string 2 to number string
		char[] c2 = solutionChar(crypt[1], solution);
		if (c2[0] == '0' && c2.length > 1)
			return false;

		// convert string 3 to number string
		char[] c3 = solutionChar(crypt[2], solution);
		if (c3[0] == '0' && c2.length > 1)
			return false;

		return Long.parseLong(new String(c1)) + Long.parseLong(new String(c2)) == Long.parseLong(new String(c3));


	}

}
