package com.codefight.challanges;

public class AlienBit {

	public static void main(String[] args) {
		String alien = "0.116101115116105110103046046046032049050051052053054055056057049048";
		System.out.println(alienBit(alien));
		
	}
	static String alienBit(String abit) {
	    abit = abit.substring(2);
		int i = 0;
		int j = 3;
		StringBuilder sb = new StringBuilder();
		while(i < abit.length()){
			sb.append((char)(Integer.valueOf(abit.substring(i, j))).intValue());
			i = i + 3;
			j = j + 3;
			if(j > abit.length()) j = abit.length()-1;
		}
	    return sb.toString();
	}


}
