package com.paigeruppel.interviewpractice.counting;

import java.util.HashMap;
import java.util.Map;

public class Telephone {

	public String[] pressingButtons(String buttons) {
		int length = (int) Math.pow(3, buttons.length());
		String[] messages = new String[length];
		for (int i = 0; i < messages.length; i++) {
			messages[i] = "";
		}
		
		return messages;
	}
	
	private Map<Character, Character[]> buildMap() {
		Map<Character, Character[]> numberChars = new HashMap<>();
		Character[] two = { 'a', 'b', 'c' };
		Character[] three = { 'd', 'e', 'f' };
		Character[] four = { 'g', 'h', 'i' };
		numberChars.put('2', two);
		numberChars.put('3', three);
		numberChars.put('4', four);
		return numberChars;
	}

}
