package com.danielsolawa.codefights.challenges.solutions;

public class IncorrectPasscodeAttempts {

	boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
		int numOfAttempts = Integer.MIN_VALUE;
		int currentAttempts = 0;
		for (int i = 0; i < attempts.length; i++) {
			if(!attempts[i].equals(passcode))
				currentAttempts++;
			else {
				numOfAttempts = Math.max(currentAttempts, numOfAttempts);
				currentAttempts = 0;
			}
			
		}
		
		numOfAttempts = Math.max(currentAttempts, numOfAttempts);
	
		
		return numOfAttempts  >= 10 ? true : false;
	}
	
	
}
