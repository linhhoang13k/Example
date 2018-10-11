package exercise20;

public class AdjacentMaxDifference {

	public int arrayMaximalAdjacentDifference(int[] inputArray) {
		int maxDifference = 0;
		
		for (int ind = 1; ind < inputArray.length; ind++) {
			int preInd = ind - 1;
			int absDifference = Math.abs(inputArray[ind] - inputArray[preInd]);
			
			if (absDifference > maxDifference) {
				maxDifference = absDifference;
			}
			
		}
		return maxDifference;
	}

}
