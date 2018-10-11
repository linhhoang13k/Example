package exercise28;

import java.util.HashMap;
import java.util.Map;

public class AlphabetShifter {

	public String alphabeticShift(String inputString) {
		char[] inputArray = inputString.toCharArray();
		String answer = "";
		
		for (int i = 0; i < inputArray.length; i++) {
			 char k = inputArray[i];
			 answer = answer + shiftedAlphabet().get(k);
		}
		return answer;
	}
	
	static Map<Character, String> shiftedAlphabet() {

		Map<Character, String> shifter = new HashMap<>();
		
		shifter.put('a', "b");
		shifter.put('b', "c");
		shifter.put('c', "d");
		shifter.put('d', "e");
		shifter.put('e', "f");
		shifter.put('f', "g");
		shifter.put('g', "h");
		shifter.put('h', "i");
		shifter.put('i', "j");
		shifter.put('j', "k");
		shifter.put('k', "l");
		shifter.put('l', "m");
		shifter.put('m', "n");
		shifter.put('n', "o");
		shifter.put('p', "q");
		shifter.put('q', "r");
		shifter.put('r', "s");
		shifter.put('s', "t");
		shifter.put('t', "u");
		shifter.put('u', "v");
		shifter.put('v', "w");
		shifter.put('w', "x");
		shifter.put('x', "y");
		shifter.put('y', "z");
		shifter.put('z', "a");
		
		
		return shifter;
		
	}

}
