import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		System.out.println(firstNonRepeatingCharFast("abacabad"));
		System.out.println(firstNonRepeatingCharFast("abacabaabacaba"));
		System.out.println(firstNonRepeatingCharFast("a"));
		
	}
	
	public static char firstNonRepeatingChar(String s){
		if(s.length()==1) {
			return s.charAt(0);
		}
		for(int i = 0; i<s.length(); i++){
			char p = s.charAt(i);
			if(s.substring(i+1,s.length()).indexOf(p)==-1 && s.substring(0, i-1).indexOf(p)==-1) {
				return p;
			}
		}
		return '_';
	}



	public static char firstNonRepeatingCharFast(String s){
		LinkedHashMap <Character, Integer> asd = new LinkedHashMap();
		
		if(s.length()==1) {
			return s.charAt(0);
		}

		
		char[] a = s.toCharArray();
		
		for (int k = 0; k<s.length(); k++){
			if(asd.containsKey(a[k])){
				Integer count = asd.get(a[k]);
				asd.put(a[k], ++count);
			} else {
				asd.put(a[k], 1);
			}
			
		}
		for(Map.Entry e: asd.entrySet()){
			if((Integer)e.getValue()==1){
				return (char)e.getKey();
			}
		}
		return '_';
	}
}
