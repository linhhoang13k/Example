package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Tour1708 {

	int chessBoardSquaresUnderQueenAttack(int a, int b) {
		int s = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int x = 0; x < a; x++) {
					for (int y = 0; y < b; y++) {
						if (!(i == x && j == y)
								&& (x == i || y == j || Math.abs(i - j) == Math.abs(x - y) || x + y == i + j))
							s++;
					}
				}
			}
		}
		String note = "";
		note.toCharArray();
		return s;
	}

	String stolenLunch(String note) {
		char[] c = note.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= '0' && c[i] <= '9') {
				c[i] = (char) ((int) 'a' + c[i] - '0');
			} else if (c[i] >= 'a' && c[i] <= 'j') {
				c[i] = (char) ((int) '0' + c[i] - 'a');
			}
		}
		return new String(c);
	}

	boolean bishopAndPawn(String bishop, String pawn) {
		int x1 = bishop.charAt(0) - 'a' + 1;
		int y1 = bishop.charAt(1) - '0';
		int x2 = pawn.charAt(0) - 'a' + 1;
		int y2 = pawn.charAt(1) - '0';
		return (x1 + y1) == (x2 + y2) || Math.abs(y1 - x1) == Math.abs(y2 - x2);
	}

	int commonCharacterCount(String s1, String s2) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		int answer = 0;
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			map1.put(ch, map1.containsKey(ch) ? (map1.get(ch) + 1) : 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			map2.put(ch, map2.containsKey(ch) ? (map2.get(ch) + 1) : 1);
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			answer += Math.min(map1.get(ch), map2.get(ch));
		}
		return answer;
	}
	
	String[] sortByLength(String[] inputArray) {
	    for(int i = 0; i < inputArray.length-1; i++){
	        for(int j = i+1; j < inputArray.length; j++){
	            if(inputArray[i] .length() > inputArray[j].length()){
	                swap(inputArray,i,j);
	            }
	        }
	    }	
	    return inputArray;
	}

	void swap(String[] a, int i, int j){
	    String tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	}
	
	String[] sortByLength2(String[] inputArray) {
	    for(int i = 1; i < inputArray.length; i++){
	        int l = inputArray[i].length();
	        String cur = inputArray[i];
	        int j = i-1;
	        while(j >= 0 && inputArray[j].length() > l){
	            inputArray[j+1] = inputArray[j];
	            j--;
	        }
	        inputArray[j+1] = cur;
	    }	
	    return inputArray;
	}

	Integer[] digitDifferenceSort(Integer[] a) {
		Arrays.sort(a, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int diff1 = diff(o1);
				int diff2 = diff(o2);
				if(diff1 == diff2){
					for(int i = 0; i < a.length; i++){
						if(a[i].intValue() == o1.intValue()) return 1;
						if(a[i].intValue() == o2.intValue()) return -1;
					}
				}
				return diff1 - diff2;
			}
		});
		return a;
	}
	
	int diff(int x){
		int max = 0, min = x;
		String s = x+"";
		if(s.length() == 1) return 0;
		for(int i = 0; i < s.length(); i++){
			int c = s.charAt(i) - '0';
			if(c > max) max = c;
			if(c < min) min = c;
		}
		return max - min;
	}
	
	int arrayConversion(Integer[] inputArray) {
	    List<Integer> x = Arrays.asList(inputArray);
	    List<Integer> y = new ArrayList<>();
	    int step = 0;
	    while (x.size() > 1) {
	    	y = new ArrayList<>();
			if(step % 2 == 0){
				for(int i = 0; i < x.size()-1; i+=2){
					y.add(x.get(i) + x.get(i+1));
				}
			}else{
				for(int i = 0; i < x.size()-1; i+=2){
					y.add(x.get(i) * x.get(i+1));
				}
			}
			step++;
			x = y;
		}
	    return x.get(0);
	}


	public static void main(String[] args) {
		Tour1708 t = new Tour1708();
		String[] x = { "thitl", "", "sadhxirg", "hx", "ondyxds", "kncor", "sqrg", "hqtchyxku", "rl", "wd" };
		Integer[] y = {152, 23, 7, 887, 243};
		System.out.println(t.sortByLength2(x));
	}
}
