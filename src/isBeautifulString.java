package com.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*A string is said to be beautiful if b occurs in it no more times than a; 
 * c occurs in it no more times than b; and so on.....

Given a string, check whether it is beautiful.

Example

For inputString = "bbbaacdafe", the output should be
isBeautifulString(inputString) = true;
For inputString = "aabbb", the output should be
isBeautifulString(inputString) = false;
For inputString = "bbc", the output should be
isBeautifulString(inputString) = false.
 * 
 */

// first method long and complex
public class IsBeautifulString {

	public static void main(String[] args) {
		String s="abcdefghijklmnopqrstuvwxyzz";
		String s1 = "bbbaacdafe";
		String s2="bbc";
		System.out.println(isBeautifulString(s));
		System.out.println(isBeautifulShort(s2));
		System.out.println(isBeautifulSuperShort(s1));
	}
	static boolean isBeautifulString(String s) {
		Comparator<Character> cmp  = new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return c1.compareTo(c2);
			}
		};
		Map<Character, Integer> treeMap = new TreeMap<Character, Integer>(cmp);
		for (int i=0; i<26;i++) {
			char c = (char) ('a'+i);
			treeMap.put(c, 0);
		}
		for (Character ch: s.toCharArray()) {
			if (treeMap.containsKey(ch)) {
				int count = treeMap.get(ch);
				treeMap.put(ch, count+1);
			} 
		}
		List<Integer> list = new ArrayList<>(treeMap.values());
		for (int i=0; i<list.size()-1; i++) {
			int curr = list.get(i);
			int next = list.get(i+1);
			if (!(curr>=next)) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isBeautifulShort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<26;i++) {
			char c = (char) ('a'+i);
			map.put(c, 0);
		}
		for (Character ch: s.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} 
		}
		for (int i= Character.valueOf('a'); i<Character.valueOf('z'); i++) {
			char c = (char) i;
			if (map.get(c) < map.get((char)(i+1))) {
				return false;
			}
		}
		
		return true;
	}
	static boolean isBeautifulSuperShort(String s) {		
		int a[] = new int[26];
		for (Character c: s.toCharArray()) {
			a[c-'a']++;
		}
		for (int i=0; i<25; i++) {
			if (a[i]<a[i+1]){
				return false;
			}
		}
		return true;
	}

}
