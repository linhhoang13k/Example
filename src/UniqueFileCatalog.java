package exercise57;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueFileCatalog {

	/*
	 * You are given an array of desired filenames in the order of their creation.
	 * Since two files cannot have equal names, the one which comes later will have
	 * an addition to its name in a form of (k), where k is the smallest positive
	 * integer such that the obtained name is not used yet.
	 * 
	 * Return an array of names that will be given to the files.
	 */
	Set<String> uniqueNames = new HashSet<String>();
	List<String> validNames = new ArrayList<>();

	public String[] fileNaming(String[] names) {
		for (String currentEntry: names) {
			if (!uniqueNames.contains(currentEntry)) {
				addEntryToSetAndList(currentEntry);
			} else {
				int k = 1;
				while (uniqueNames.contains(appendSuffixToFile(currentEntry, k))) {
					k++;
				}
				String uniqueEntry = appendSuffixToFile(currentEntry, k); 
				addEntryToSetAndList(uniqueEntry);
			}
		}
		return validNames.toArray(new String[names.length]);
	}

	private void addEntryToSetAndList(String currentEntry) {
		uniqueNames.add(currentEntry);
		validNames.add(currentEntry);
	}

	private String appendSuffixToFile(String currentEntry, int k) {
		return currentEntry + "(" + k + ")";
	}
}
