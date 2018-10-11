package com.codefight.interviewpractice;

import java.util.Arrays;

public class PressingButtons2 {

	public static void main(String[] args) {
		String[] results = pressingButtons("8888");

		System.out.println("Length: " + results.length);
		for(String r: results){
			System.out.print(r + " ");
		}
	}

	static String[] pressingButtons(String buttons) {
		char[][] baseData = new char[][] { {}, // 0
				{}, // 1
				{ 'a', 'b', 'c' }, // 2
				{ 'd', 'e', 'f' }, // 3
				{ 'g', 'h', 'i' }, // 4
				{ 'j', 'k', 'l' }, // 5
				{ 'm', 'n', 'o' }, // 6
				{ 'p', 'q', 'r', 's' }, // 7
				{ 't', 'u', 'v' }, // 8
				{ 'w', 'x', 'y', 'z' } // 9
		};

		char[][] requiredData = new char[buttons.length()][];
		int matrixLength = 0;
		for (int i = 0; i < buttons.length(); i++) {
			char[] buttonChars = baseData[Integer.valueOf(String.valueOf(buttons.charAt(i)))];
			requiredData[i] = buttonChars;
			if (matrixLength == 0) {
				matrixLength = buttonChars.length;
			} else {
				matrixLength *= buttonChars.length;
			}
		}

		String[] result = new String[matrixLength];
		Arrays.fill(result, "");

		int d0length = 0;
		int mapper = 0;

		for (int d = 0; d < requiredData.length; d++) {
			int r = 0;
			char[] currData = requiredData[d];

			if (d == 0) {
				d0length = matrixLength / currData.length;
				mapper = matrixLength / currData.length;
				for (char c : currData) {
					for (int k = 0; k < d0length; k++) {
						result[r] = result[r] + c;
						r++;
					}
				}
			} else {
				mapper = mapper / currData.length;
				for (int k = 0; k < d0length; k++) {
					for (char c : currData) {
						for (int y = 0; y < mapper; y++) {
							if (r == matrixLength)
								break;
							result[r] = result[r] + c;
							r++;
						}
					}
				}
			}
		}
		return result;
	}

}
