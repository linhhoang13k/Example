package exercise25;

public class ArrayReplacer {
	/**
	 * Given an array of integers, replace all the occurrences of elemToReplace
	 * with substitutionElem.
	 * 
	 * Example
	 * 
	 * For inputArray = [1, 2, 1], elemToReplace = 1 and substitutionElem = 3,
	 * the output should be arrayReplace(inputArray, elemToReplace,
	 * substitutionElem) = [3, 2, 3].
	 */

	public int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		int[] answer = new int[inputArray.length];
		
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == elemToReplace) {
				answer[i] = substitutionElem;
			} else {
				answer[i] = inputArray[i];
			}
		}
		return answer;
		
	}

}
