/**
 *
 * @author chandantroughia
 * @date 07/07/2017
 * @asked Palantir
 * 
 */

import java.util.HashMap;

public class IsCryptySolution {

	private static boolean isCryptSolution(String[] crypt, char[][] solution) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		for(int i = 0; i < solution.length; i++){
			for(int j = 0; j < 1; j++){
				map.put(solution[i][j], (solution[i][j+1]));
			}
		}
		
		int[] digits = new int[3];
		
		for(int i = 0; i < crypt.length; i++){
			int n = crypt[i].length();
			String word = "";
			
			if(map.get(crypt[i].charAt(0)) == '0') return false;
			
			
			
			for(int j = 0; j < n; j++){
				
				word += map.get(crypt[i].charAt(j));
			}
			
			if(word.length() != (int)(Math.log10(Integer.valueOf(word))+1) ) return false;
			
			
			digits[i] = Integer.valueOf(word);
		}
		
		int sum = 0;
		
		for(int i = 0; i < digits.length - 1; i++){
			sum += digits[i];
		}
		
		return sum == digits[2];
		
	}

	public static void main(String[] args) {
		String[] crypt1 = {"WASD", 
				 "IJKL", 
				 "AOPAS"};
		
		char[][] solution1 = {{'W','2'}, 
				{'A','0'}, 
				{'S','4'}, 
				{'D','1'}, 
				{'I','5'}, 
				{'J','8'}, 
				{'K','6'}, 
				{'L','3'}, 
				{'O','7'}, 
				{'P','9'}
		};
							  
//		
//		String[] crypt2 = {"TEN", "TWO", "ONE"};
//		char[][] solution2 = {{'O', '0'},
//							  {'T', '1'},
//							  {'W', '2'},
//							  {'E', '5'},
//							  {'N', '6'}};
							 
		System.out.println(isCryptSolution(crypt1, solution1));
							 

		//System.out.println(isCryptSolution(crypt2, solution2));
	}
}
