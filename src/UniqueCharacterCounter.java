package exercise36;

import java.util.ArrayList;
import java.util.List;

public class UniqueCharacterCounter {

	public int differentSymbolsNaive(String s) {
		List<Character> distinctChars = new ArrayList<>();
		char[] input = s.toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (!distinctChars.contains(input[i])) {
				distinctChars.add(input[i]);
			}
		}
		return distinctChars.size();
	}

}
