package strings;

import java.util.Arrays;

public class AreIsomorphic {
	
	public static int SIZE = 256;
	
	public boolean areIsomorphic(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 != len2) 
			return false;
		
		Boolean[] marked = new Boolean[SIZE];
		Arrays.fill(marked, Boolean.FALSE);
		
		int[] map = new int[SIZE];
		Arrays.fill(map, -1);
		
		for(int i = 0; i < len1; i++) {
			if(map[str1.charAt(i)] == -1) {
				
				if(marked[str2.charAt(i)])
					return false;
				
				marked[str2.charAt(i)] = true;
				map[str1.charAt(i)] = str2.charAt(i);
				
			}
			else if(map[str1.charAt(i)] != str2.charAt(i))
				return false;
		}
		
		return true;
	}

}
