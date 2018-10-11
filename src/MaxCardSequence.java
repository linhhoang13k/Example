package com.danielsolawa.codefights.challenges.solutions;

import java.util.*;

public class MaxCardSequence {

	
	int maxCardSequence(int[] cards) {
		Arrays.sort(cards);
		Deque<Integer> deq = new LinkedList<>();
		deq.add(cards[0]);
		
		for (int i = 1; i < cards.length; i++) {
			int currentNum = cards[i];
			int lastNum = deq.peekLast();
			if((isEven(currentNum) && isEven(lastNum)) || (!(isEven(currentNum)) && !(isEven(lastNum)))) {
				continue;
			}
			
			if(currentNum > lastNum)
				deq.add(currentNum);
					
		}

		
		return deq.size();
	}


	boolean isEven(int n) {
		return n % 2 ==0;
	}
	
	
}
