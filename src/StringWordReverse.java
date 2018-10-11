package com.iub.coding.practice.CodeName47;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringWordReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> test = new HashMap<Integer, String>();

		test.put(3, "Sugar");
		test.put(10, "Abhijit");
		test.put(7, "Malloc");

		TreeMap<Integer, String> sorted = new TreeMap<Integer, String>(test);

		System.out.println(sorted);

		List<Entry<Integer, String>> output = new LinkedList<Entry<Integer, String>>(test.entrySet());
		
		Collections.sort(output, new Comparator<Map.Entry<Integer, String>>() {

			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				// TODO Auto-generated method stub
				
				
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		System.out.println(output);

	}

	public static String revString(String source) {

		return null;
	}

}
