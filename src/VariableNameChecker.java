package exercise27;

import java.util.ArrayList;

public class VariableNameChecker {

	public boolean variableName(String name) {
		boolean answer = true;
		char[] input = name.toCharArray();
		
		if (allowedInput().contains(input[0])) { 
		for (int i = 1; i < input.length; i++) {
			if (allowedInput().contains(input[i]) || allowedDigits().contains(input[i])) {
				continue;
			} else {
				answer = false;
				break;
			}
		}
		} else {
			answer = false;
		}
		return answer;
	}
	
	static ArrayList<Character> allowedInput() {
		String alphabet = "abcdefghijklmnopqrstuvwyxz";
		String upperAlphabet = alphabet.toUpperCase();
		
		char[] lowerCase = alphabet.toCharArray();
		char[] upperCase = upperAlphabet.toCharArray();
		ArrayList<Character> permitted = new ArrayList<>();
		
		for (char l : lowerCase) {
			permitted.add(l);
		}
		for (char u : upperCase) {
			permitted.add(u);
		}
		
		permitted.add('_');
		return permitted;
	}
	
	static ArrayList<Character> allowedDigits() {
		String digits = "1234567890";
		
		char[] numbers = digits.toCharArray();
		ArrayList<Character> permittedDigits = new ArrayList<>();
		
		for (char d : numbers) {
			permittedDigits.add(d);
		}
		
		return permittedDigits;
	}
	
	

}
