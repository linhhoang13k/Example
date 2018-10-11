package com.codefight.challanges;

public class Numeronym {

	public static void main(String[] args) {
		String s = "A numeronym is a number-based word. Most commonly, "
					+ "a numeronym is a word where a number is used to form an "
					+ "abbreviation (albeit not an acronym or an initialism). "
					+ "Pronouncing the letters and numbers may sound similar to "
					+ "the full word: \"K9\" for \"canine\" (phonetically: \"kay\" + \"nine\").";
		
	}
	
	static String n7m(String sentence) {
		String[] sAry = sentence.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for (String s : sAry) {
			if(s.length() > 2){
				sb.append(getn7m(s)).append(" ");
			}else{
				sb.append(s).append(" ");
			}
		}
		return sb.toString().trim();
	}
	
	static String getn7m(String word){
		String reqdChar = "[^a-zA-Z\\s+]";

		return reqdChar;
	}



}
