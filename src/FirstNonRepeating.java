/**
 *
 * @author chandantroughia
 * @date 07/07/2017
 * @asked Amazon
 * 
 */

import java.util.HashMap;

public class FirstNonRepeating {

	public static char firstNonRepeating(String s){
		char[] count = new char[256];
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i)]++;
		}
		
		for(int i = 0; i < s.length(); i++){
			if(count[s.charAt(i)] == 1) return s.charAt(i);
		}
		
		return '_';
	}
	
	public static char usingHashMap(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		for(Character key: map.keySet()){
			if(map.get(key) == 1){
				return (char) key;
			}
		}
		
		return '_';
	}
	
	public static char newApproach(String s){
		char[] ch = s.toCharArray();
		for(int i = 0; i < s.length(); i++){
			if(s.indexOf(ch[i]) == s.lastIndexOf(ch[i])) return ch[i];
		}
		return '_';
	}
	
	
	public static void main(String[] args) {
		String s = "abacabad";
		System.out.println(firstNonRepeating(s));
		System.out.println(usingHashMap(s));
		System.out.println(newApproach(s));
	}
}
