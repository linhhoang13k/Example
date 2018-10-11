package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Glasses {

	public static void main(String[] args) {

		System.out.println(new Glasses().threeGlasses(new int[] { 41, 61, 79 }));

	}

	// this set contains all combinations from emptying or pouring water from
	// a glass to another, its purpose is to avoid computing a combination more
	// than
	// one time and avoid infinite recursion
	Set<String> volumeCombinations = new HashSet<String>();

	// This set contains the total end volumes of the combinations.
	Set<Integer> validVolumes = new HashSet<Integer>();

	// The volume capacities of the glasses
	int[] capacities;

	int threeGlasses(int[] cap) {


		// if all the glasses have the same capacity, return cap.length
		
		int element = cap[0];
		boolean sameElement = true;
		for (int i = 1; i < cap.length; i++) {
			if (cap[i] != element) {
				sameElement = false;
			}

		}
		if (sameElement) {
			return cap.length;
		}

		capacities = cap.clone();

		// calculate all possible moves that generate volumes and store the
		// results in the sets
		possibleMoves(cap);

		// add total volume
		validVolumes.add(cap[0] + cap[1] + cap[2]);

		return validVolumes.size();
	}

	void possibleMoves(int[] cap) {

		ArrayList<int[]> volumeCombinations = new ArrayList<int[]>();

		// calculate the volumes resulting on emptying each glass of water
		// separately, and if emptying is possible

		for (int i = 0; i < cap.length; i++) {
			// if the glass is already empty, skip
			if (cap[i] == 0) {
				continue;
			}

			// the glass is not empty and there is at least one other non-empty
			// glass
			for (int j = 0; j < cap.length; j++) {
				if (i != j && cap[j] > 0) {
					int[] combination = cap.clone();
					combination[i] = 0;
					if (!setContains(combination)) {
						volumeCombinations.add(combination);
					}
					break;
				}
			}

		}

		// calculate the volumes resulting of all the possible combinations
		// of pouring a glass of water into another

		for (int i = 0; i < cap.length; i++) {
			for (int j = 0; j < cap.length; j++) {

				int destinationCapacity = capacities[j] - cap[j];

				if (i == j || cap[i] == 0 || destinationCapacity == 0) {
					continue;
				}

				int[] volumes = new int[cap.length];
				System.arraycopy(cap, 0, volumes, 0, cap.length);

				int from = volumes[i];

				if (volumes[i] > 0 || destinationCapacity > 0) {

					if (destinationCapacity >= from) {
						volumes[j] += volumes[i];
						volumes[i] = 0;

					} else {
						volumes[i] -= destinationCapacity;
						volumes[j] += destinationCapacity;

					}

					if (!setContains(volumes))
						volumeCombinations.add(volumes);

				}

			}

		}

		for (int[] combination : volumeCombinations) {
			// adding the total volume of the combination to a set
			validVolumes.add(getCombinationVolume(combination));

			// adding the combination to a set
			addCombinationToSet(combination);

			possibleMoves(combination);
		}

	}

	// adds the combination to a set
	void addCombinationToSet(int[] combination) {
		volumeCombinations.add(combinationToString(combination));
	}

	// returns true if a combination is already in the set or false otherwise
	boolean setContains(int[] combination) {
		return volumeCombinations.contains(combinationToString(combination));
	}

	// gets the total volume of a combination
	int getCombinationVolume(int[] combination) {

		int value = 0;
		for (int i = 0; i < combination.length; i++) {
			value += combination[i];
		}
		return value;
	}

	// returns a string representation of the combination (comma separated
	// values)
	String combinationToString(int[] combination) {
		String combinationStr = combination[0] + "";

		for (int i = 1; i < combination.length; i++) {
			combinationStr += "," + combination[i];
		}
		return combinationStr;
	}

}
