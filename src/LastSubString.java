package com.iub.coding.practice.CodeName47;

public class LastSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "banana";
		int maxPos = 0;
		char max = input.charAt(0);
		int count = 0, globalMax = 0, index = 0;

		for (int i = 1; i < input.length(); i++) {

			if (max < input.charAt(i)) {
				max = input.charAt(i);
				maxPos = i;
			}

		}

		String subs[] = input.split(max + "");

		for (int i = 1; i < subs.length; i++) {

			count = 0;
			for (int j = 0; j < subs[i].length(); j++) {

				count += subs[i].charAt(j);

			}

			if (globalMax < count) {
				globalMax = count;

				index = i;
			}

		}

		StringBuffer sb = new StringBuffer();
		for (int i = index; i < subs.length; i++) {
			
			sb.append(max);
			sb.append(subs[i]);
			
			

		}

		System.out.println(sb.toString());

	}

}
