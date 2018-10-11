package codefights;

import java.util.ArrayList;

public class CommonCharacterCount {

	int commonCharacterCount(String s1, String s2) {

		int common = 0;

		// convert first string to an ArrayList of Characters
		ArrayList<Character> array1 = new ArrayList<Character>();
		for (char c1 : s1.toCharArray()) {
			array1.add(c1);
		}
		// convert second string to an ArrayListof Characters
		ArrayList<Character> array2 = new ArrayList<Character>();
		for (char c2 : s2.toCharArray()) {
			array2.add(c2);
		}

		for (int index = 0; index < array1.size(); index++) {
			if (array2.contains(array1.get(index))) {
				// when second ArrayList has a common character, remove that
				// character (so it is not counted twice)
				// and increment the common count
				array2.remove(array1.get(index));
				common++;
			}
		}
		return common;
	}
}
