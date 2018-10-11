package exercise16;

import java.util.ArrayList;
import java.util.Collections;

public class SwappingPairs {

	public int differences(int[] a, int[] b) {
		int differences = 0;

		for (int ind = 0; ind < a.length; ind++)
			if (a[ind] != b[ind]) {
				differences++;
			}
		return differences;
	}

	public int swapped(int[] a, int[] b) {
		int swappedPairs = 0;
		int maxIndex = a.length - 1;
		for (int ind = 0; ind < a.length; ind++) {
			int swapUp = ind + 1;
			if (a[ind] != b[ind]) {
				if (ind == maxIndex) {
					break;
				}
				if (a[swapUp] == b[ind] && a[ind] == b[swapUp]) {
					swappedPairs++;
				}
			}
		}
		return swappedPairs;
	}

	//method will work only for adjacent swaps
	public int swapAndDifferences(int[] a, int[] b) {
		int swappedPairs = 0;
		int differences = 0;
		int maxIndex = a.length - 1;

		for (int ind = 0; ind < a.length; ind++) {
			int swapUp = ind + 1;
			if (a[ind] != b[ind]) {
				if (ind == maxIndex) {
					differences++;
					break;
				}
				if (a[swapUp] == b[ind] && a[ind] == b[swapUp]) {
					swappedPairs++;
					ind++;
				} else {
					differences++;
				}
			}
		}
		int changes = swappedPairs + differences;

		return changes;
	}

	//method for non-adjacent swaps
	boolean areSimilar(int[] a, int[] b) {

		int differences = 0;

		ArrayList<Integer> aDifferences = new ArrayList<Integer>();
		ArrayList<Integer> bDifferences = new ArrayList<Integer>();

		for (int ind = 0; ind < a.length; ind++) {
			if (a[ind] != b[ind]) {
				aDifferences.add(differences, a[ind]);
				bDifferences.add(differences, b[ind]);
				differences++;
			}
		}

		if (differences == 0) {
			return true;
		} else if (differences > 2) {
			return false;
		} else {
			Collections.sort(aDifferences);
			Collections.sort(bDifferences);
			if (aDifferences.equals(bDifferences)) {
				return true;
			} else {
				return false;
			}
		}

	}
}
