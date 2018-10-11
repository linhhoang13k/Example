package tiendm.codefight.challenge.may;

import java.util.ArrayList;
import java.util.List;

public class WordsRotationCc {
	String[] wordsRotationCc(String[] words) {
		if(words.length == 0) return words;
		List<String> l = new ArrayList<>();
		for(int i = words[0].length()-1; i >= 0; i--){
			StringBuilder s = new StringBuilder();
			for(int j = 0; j < words.length; j++){
				s.append(words[j].charAt(i));
			}
			l.add(s.toString());
		}
		return l.toArray(new String[l.size()]);
	}
	
	public static void main(String[] args) {
		
	}
}
