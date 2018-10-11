package codefights.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoSolution {

	public static void main(String[] args) {
		CryptoSolution s = new CryptoSolution();
		
		String[] crypt = 
			{"AAAAAAAAAAAAAA", 
				 "BBBBBBBBBBBBBB", 
				 "CCCCCCCCCCCCCC"}
		
		;
		
		
		char[][] solution = 
			{
//					{'O', '0'},
//		                  {'M', '1'},
//		                     {'Y', '2'},
//		                     {'E', '5'},
//		                     {'N', '6'},
//		                     {'D', '7'},
//		                     {'R', '8'},
//		                     {'S', '9'}
					
//				{'O','0'}, 
//				 {'T','1'}, 
//				 {'W','2'}, 
//				 {'E','5'}, 
//				 {'N','6'}
					
//				{'A','5'}, 
//				 {'B','6'}, 
//				 {'C','1'}

					{'A','1'},
					{'B','2'},
					{'C','3'}
					
					
			};
		
		System.out.println(s.isCryptSolution(crypt, solution));

	}
	
	
	boolean isCryptSolution(String[] crypt, char[][] solution) {

		boolean isValid = true;
		Map<Character, Character> solutionMap = new HashMap<Character, Character>();
		List<Long> sumList = new ArrayList<Long>();
		
		for (int i=0;i<solution.length;i++) {
			solutionMap.put(solution[i][0], solution[i][1]);
		}
		
		for (int i=0;i<crypt.length;i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0;j<crypt[i].length();j++) {
				char c = crypt[i].charAt(j);
//				System.out.println("c: " + c);
				c = solutionMap.get(c);
				sb.append(c);
			}
			
			if (sb.length() > 1 && sb.toString().startsWith("0")) {
				isValid = false;
				break;
			} else {
				sumList.add(Long.parseLong(sb.toString()));
			}
		}
		
		//validate a + b = c
		if (isValid) {
			long runningCount = 0;
			for (int i=0;i<sumList.size()-1;i++) {
				runningCount = runningCount + sumList.get(i);
			}
			if (runningCount != sumList.get(sumList.size()-1) ) {
				isValid = false;
			}
		}
		
		return isValid;
	}
}
