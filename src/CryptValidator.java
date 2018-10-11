/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.
*/

public class CryptValidator{
	public static void main(String[] args){
		String[] crypt = {"A", "A", "A"};
		char[][] solution = {{'A', '0'}};
		System.out.println(isCryptSolution(crypt, solution));
 	}
	
	public static boolean isCryptSolution(String[] crypt, char[][] solution) {
		long total = 0;
		for (int i = 0; i < crypt.length; i++){
			String word = "";
			for (int j = 0; j < crypt[i].length(); j++){
				for (int k = 0; k < solution.length; k++){
					if (crypt[i].charAt(j) == solution[k][0]){
						word += solution[k][1];
					}
				}
			}
			if (word.charAt(0) == '0' && word.length() > 1){
				return false;
			}
			if (Long.parseLong(word) != total && i == 2){
				return false;
			}
			total += Long.parseLong(word);
		}
		return true;
	}
}