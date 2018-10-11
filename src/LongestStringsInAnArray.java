package codefights;
import java.util.ArrayList;
import java.util.Arrays;

public class LongestStringsInAnArray {

	String[] allLongestStrings(String[] inputArray) {

		ArrayList<String> input = new ArrayList<String>(Arrays.asList(inputArray));

		int max = -1000;
		ArrayList<String> longestStrings = new ArrayList<String>();
		for (String s : input) {
			int length = s.length();
			if (length > max) {
				max = length;
				longestStrings.clear();
				longestStrings.add(s);
			} else if (length == max) {
				longestStrings.add(s);
			}
		}
		String[] longest = longestStrings.toArray(new String[longestStrings.size()]);
		return longest;

	}

}
