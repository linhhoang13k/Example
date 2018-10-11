package com.sample.lukyNumber;

import java.util.ArrayList;
import java.util.List;

public class LukyNumberMain {
/**
 * Ticket numbers usually consist of an even number of digits. 
 * A ticket number is considered lucky if the sum of the first half of the digits 
 * is equal to the sum of the second half.
 * 
 */
	
	public static boolean isLuky(int n){
	
		int sumA = 0;
		int sumB = 0;
		
		List <Integer> numList = new ArrayList<>();
		while(n>0){
			numList.add(n%10);
			n/=10;
		}
		
		for(int i=0;i<numList.size()/2;i++){
			sumA+=numList.get(i);
			sumB+=numList.get((numList.size()-1)-i);
		}
		if (sumA==sumB){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(isLuky(1230));

	}

}
