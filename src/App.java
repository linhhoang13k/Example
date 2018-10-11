package com.iub.coding.practice.CodeName47;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		char a = '2';
		char b = '3';

		String first = "10000000000";
		String sec = "10000000000";

	
		String op = "";
		
		

		int dig1, dig2, carry = 0, mult = 0, tempcount = 0, add = 0;

		int[][] calc = new int[sec.length()][first.length()];

		for (int i = first.length() - 1; i >= 0; i--) {

			for (int j = 0; j < sec.length(); j++) {

				dig1 = first.charAt(i) % 48;
				dig2 = sec.charAt(j) % 48;

				calc[j][i] = dig1 * dig2;
			}
		}

	
		for (int i = first.length() - 1; i >= 0; i--) {

			tempcount = i;
			add = 0;
			add += carry;
			carry = 0;
			for (int j = sec.length() - 1; j >= 0 && tempcount < first.length(); j--, tempcount++) {

				add += calc[j][tempcount]%10;
				carry += calc[j][tempcount] / 10;
				
			}
			
			op = add%10 + op;
			carry += add/10;
		}
		
		for (int i = sec.length() - 2; i >= 0; i--) {

			tempcount = i;
			add = 0;
			add += carry;
			carry = 0;
			for (int j = 0; j < first.length() && tempcount >= 0; j++, tempcount--) {

				add += calc[tempcount][j]%10;
				carry += calc[tempcount][j] / 10;
				
				
			}
			
			op = add%10 + op;
			carry += add/10;
		}
		
		if(carry != 0)	{
			op = carry + op;
		}
			
		System.out.println(op);
	}
}
