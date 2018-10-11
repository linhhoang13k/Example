package codefighters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MirrorLake {
	static int stringsConstruction(String A, String B) {
		int count = 100;
		char[] letters = new char[10];
		int [] counting = new int[10];
		int [] countingB = new int[10];
		for(int i = 0, k = 0; i < A.length(); i++){
			if(!isThere(letters, A.charAt(i))){
				letters[k] = A.charAt(i);
				for(int j = i; j< A.length(); j++){
					if(A.charAt(j) == letters[k]){
						counting[k]++;
					}
				}
				k++;
			}
		}
		for(int i = 0; i < letters.length && letters[i] > 0 ; i++){
			for(int j = 0; j < B.length(); j++){
				if(letters[i] == B.charAt(j)){
					countingB[i]++;
				}
			}
			counting[i] = countingB[i] / counting[i];
			if(count > counting[i]){
				count = counting[i];
			}
		}
		return count;
	}

	static boolean isThere(char[] letters, char current){
		for(int i = 0; i < letters.length; i++){
			if(current == letters[i]){
				return true;
			}
		}
		return false;
	}

	static boolean isSubstitutionCipher(String string1, String string2) {
		char[] A = new char[10];
		char[] B = new char[10];
		boolean exist = false;
		int a = 0;

		for(int i = 0; i < string1.length(); i++){
			exist = false;
			for(int j = 0; j < A.length; j++){
				if(string1.charAt(i) == A[j] || string2.charAt(i) == B[j]){
					exist = true;
					if(string2.charAt(i) != B[j] || string1.charAt(i) != A[j]){
						return false;
					}else
						break;
				}
			}
			if(!exist){
				A[a] = string1.charAt(i);
				B[a] = string2.charAt(i);
				a++;
			}
		}
		return true;
	}

	static int createAnagram(String s, String t) {
		for(int i = 0; i < s.length(); i++){
			t = t.replaceFirst(s.charAt(i)+"", "");
		}
		return t.length();
	}

	static int constructSquare(String s) {
		int base1 = 4, base2 = 4, result = -1;
		ArrayList<Integer> letter = new ArrayList<Integer>();
		ArrayList<Integer> number = null;


		//		while(((base1*base1)+"").length() < s.length()){
		//			base1++;
		//		}
		//		base2 = base1;
		//		while(((base2*base2)+"").length() <= s.length()){
		//			base2++;
		//		}

		base1 = (int)Math.sqrt(Math.pow(10, s.length()-1));
		base2 = (int)Math.sqrt(Math.pow(10, s.length()));

		while(s.length() > 0){
			int i = s.length();
			s = s.replace(s.charAt(0) + "", "");
			letter.add(i - s.length());
		}

		for(;base1 <= base2; base1++){
			String sqre = base1 * base1 + "";
			number = new ArrayList<Integer>();
			while(sqre.length() > 0){
				int i = sqre.length();
				sqre = sqre.replace(sqre.charAt(0) + "", "");
				number.add(i - sqre.length());
			}
			if(letter.size() == number.size() && letter.containsAll(number)){
				result = base1 * base1;
			}
		}
		return result;
	}

	static int numbersGrouping(int[] a) {
		int lines = 0;
		int[] groups = new int[100000];
		List<Integer> numbers = new ArrayList<Integer>(){{for(int i : a) add(i);}};

		for(int current : numbers){
			int i = 0;
			i = current/10000;
			if(i > 0 && current%10000 == 0){
				i--;
			}
			if(groups[i] == 0){
				lines++;
			}
			groups[i]++;
		}

		return lines + numbers.size();
	}

	static int differentSquares(int[][] matrix) {
		ArrayList<int[][]> combination = new ArrayList<int[][]>();
		if(matrix.length >=2 && matrix[0].length >= 2){
			for(int i = 0; i <= matrix.length - 2; i++){
				for(int j = 0; j<=matrix[0].length - 2; j++){
					int[][] current = {Arrays.copyOfRange(matrix[i], j, j+2), Arrays.copyOfRange(matrix[i+1], j, j+2)};
					boolean equals = false;
					for(int[][]compare:combination){
						if(Arrays.equals(current[0], compare[0]) && Arrays.equals(current[1], compare[1])){
							equals = true;
						}
					}
					if(!equals){
						combination.add(current);
					}
				}
			}
		}
		return combination.size();
	}

	static int mostFrequentDigitSum(int n) {
		List<Integer> results = new ArrayList<>();
		int res = 0, temporal = n;
		while(n > 0){
			res = 0;
			temporal = n;
			while(temporal > 0){
				res += temporal %10;
				temporal /=10;
			}
			results.add(res);
			n -=res;
		}
		int finalCount = 0, i = 0, repeat = 0;
		while( i<results.size()){
			Integer temp = results.get(i);
			int  count = 0, j = 0;
			while(j < results.size()){
				if(results.get(j) == temp){
					results.remove(j);
					count++;
				}else{
					j++;
				}
			}

			if(count > finalCount){
				finalCount = count;
				repeat = temp;
			}else if(count == finalCount && repeat < temp){
				repeat = temp;
			}
		}
		return repeat;
	}

	static int numberOfClans(int[] divisors, int k) {
		int clans = 0;
		List<int[]> results = new ArrayList<>();

		while(k > 0){
			int[] temp = new int[divisors.length];
			for(int i = 0; i < divisors.length; i++){
				temp[i]=(k%divisors[i]==0?1:0);
			}
			results.add(temp);
			k--;
		}

		while(!results.isEmpty()){
			clans++;
			int j = 0;
			int[] current = results.get(0);
			while(j < results.size()){
				if(Arrays.equals(results.get(j), current)){
					results.remove(j);
				}else{
					j++;
				}
			}
		}

		return clans;
	}


}
