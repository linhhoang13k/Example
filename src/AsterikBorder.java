package exercise15;

public class AsterikBorder {

	int columnLength(String[] input) {
		String[] test = input;
		int columnLength = test[0].length() + 2;
		return columnLength;
	}

	String columnLengthToAsterik(int length) {
		int borderWidth = length;
		String topBottomBorder = "*";
		for (int index = 0; index <= borderWidth; index++) {
			topBottomBorder += "*";
		}
		return topBottomBorder;
	}

	public String addAsterikFrontAndBack(String input) {
		char[] original = input.toCharArray();
		char[] conCat = new char[input.toCharArray().length + 2];

		for (int index = 0; index < conCat.length; index++) {
			int maxIndex = conCat.length - 1;
			if (index == 0 || index == maxIndex) {
				conCat[index] = '*';
			} else {
				conCat[index] = original[index - 1];
			}
		}
		String converted = new String(conCat);
		return converted;
	}

	String[] addBorder(String[] input) {
		char[] original = input[0].toCharArray();
		char[] conCat = new char[original.length + 2];
		String converted = "";
		String[] answer = new String[input.length + 2];
		// iterating over the array
		
		for (int index = 0; index < input.length; index++) {
			// converting the string at that index to a char array
			original = input[index].toCharArray();
			// iterating over the new char array
			for (int count = 0; count < conCat.length; count++) {
				int maxIndex = conCat.length - 1;
				if (count == 0 || count == maxIndex) {
					conCat[count] = '*';
				} else {
					conCat[count] = original[count - 1];
				}
				converted = new String(conCat);
			}
			answer[index + 1] = converted;
		}
		
		String topBottomBorder = "";
			for (int i = 0; i < conCat.length; i++) {
				topBottomBorder += "*";
			}
		answer[0] = topBottomBorder;
		answer[answer.length - 1] = topBottomBorder;

		return answer;

	}
}
