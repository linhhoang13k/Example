package tiendm.codefight.tournament.aug;

import java.util.ArrayList;

public class Tour1908 {
	int applesDistribution(int apples, int boxCapacity, int maxResidue) {
		  int result = 0;
		  for (int i = 1; i <= boxCapacity; i++) {
		    if (apples % i <= maxResidue) {
		      result++;
		    }
		  }
		  return result;
		}
	String replaceFirstDigitRegExp(String input) {
	    for(int i = 0; i < input.length(); i++){
	        if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
	            input.replaceFirst(input.charAt(i) + "", "#");
	        }
	    }
	    return input;
	}
	boolean isPangram(String sentence) {
	    for(int i = 0; i < 26; i++){
	        char c = (char)('a' + i);
	        sentence = sentence.toLowerCase();
	        if(!sentence.contains(c+"")) return false;
	    }
	    return true;
	}
	int minimalMultiple(int divisor, int lowerBound) {
	    for(int i = lowerBound; ; i++){
	        if(i % divisor == 0) return i;
	    }
	}

	public static void main(String[] args) {
		Tour1908 t = new Tour1908();
		int[] x = { 3, 5, 7, 9 };
		System.out.println(t);
	}
}
