package com.paigeruppel.interviewpractice.strings;

public class SentenceBuilder {

	public String amendTheSentence(String s) {
		String[] words = s.split("(?=[A-Z])");
		StringBuilder ammended = new StringBuilder(String.join(" ", words));
		return ammended.toString().toLowerCase();
	}

}
