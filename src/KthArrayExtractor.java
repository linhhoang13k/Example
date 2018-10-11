package exercise34;

import java.util.ArrayList;
import java.util.Arrays;

public class KthArrayExtractor {

	
	public int[] extractEachKth(int[] inputArray, int k) {
		ArrayList<Integer> input = convertInputToArrayList(inputArray);
		int kFactor = 1;
		if (k == 1) {
			input.clear();
			return convertBackToArray(input);
		}
		for (int ind = 0; ind < input.size(); ind++) {
			if (ind == (kFactor*k - kFactor)) {
				input.remove(ind);
				kFactor++;
			}
		}
		return convertBackToArray(input);
	}

	ArrayList<Integer> convertInputToArrayList(int[] inputArray) {
		ArrayList<Integer> converted = new ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			converted.add(inputArray[i]);
		}
		return converted;
	}
	
	int[] convertBackToArray(ArrayList<Integer> input) {
		int[] afterExtraction = new int[input.size()];
		for (int index = 0; index < input.size(); index++) {
			afterExtraction[index] = input.get(index);
		}
		return afterExtraction;
	}
}
