package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.List;

public class Tour2908 {

	List<String> isDivisibleBy6(String inputString) {
	    List<String> ls = new ArrayList<>();
	    int idx = 0;
	    int sum = 0;
	    for(int i = 0; i < inputString.length(); i++){
	        if(inputString.charAt(i) == '*'){
	            idx = i;
	            continue;
	        }
	        sum += inputString.charAt(i) - '0';
	    }
	    if(idx != inputString.length() - 1 && (inputString.charAt(inputString.length()-1) - '0') % 2 == 1){
	        return ls;
	    }
	    for(int i = 0; i < 10; i++){
	        if((i + sum) % 3 == 0 && (idx != inputString.length() - 1 
	                                  || (idx == inputString.length() - 1 && i % 2 == 0))){
	            ls.add(inputString.replace('*', (char)(i + '0')));
	        }
	    }
	    return ls;
	}

	int countLineColorings(int points, int colors) {
	    return colors * (int)Math.pow(colors-1, points-1);
	}

	public static void main(String[] args) {
		Tour2908 t = new Tour2908();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 0, 0, 0, 1 };
		System.out.println(t.isDivisibleBy6("1*0"));
	}
}
