package com.sample.commoncharacters;

import java.util.ArrayList;
import java.util.List;

public class CommonCharsMain {
	
	public static int commonChars(String s1, String s2){
		int counter=0;

		List <Character>ls1 = new ArrayList<>();
		List <Character>ls2 = new ArrayList<>();
		
		for(int i = 0; i < s1.length(); i++){
			ls1.add(s1.charAt(i));
		}
		for(int i = 0; i < s2.length(); i++){
			ls2.add(s2.charAt(i));
		}
		System.out.println(ls1.get(0));
		for(int i = 0; i < ls1.size(); i++){
			for(int j = 0; j < ls2.size(); j++){
				if (ls1.get(i).equals(ls2.get(j))){
					counter++;
					ls2.remove(j);
					break;
				}
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		String s1 = "abca";
		String s2 = "xyzbac";
		System.out.println(commonChars(s1,s2));
	}
}
