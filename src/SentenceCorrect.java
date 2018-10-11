package com.huynv;

public class SentenceCorrect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sentence1 = "This is an example of *correct* sentence.";
		boolean isCorrect1 = isSentenceCorrect(sentence1);
		System.out.print("Test 1: " + isCorrect1);
		String sentence2 = "!this sentence is TOTALLY incorrecT";
		boolean isCorrect2 = isSentenceCorrect(sentence2);
		System.out.print("\nTest 2: " + isCorrect2);
	}

	static boolean isSentenceCorrect(String sentence) {
		String regex = "[A-Z]+((?=[^\\?\\.\\!])([^\\?\\.\\!]+[\\?\\.\\!])|([\\?\\.\\!]))";
		return sentence.matches(regex);
		
	}
}
