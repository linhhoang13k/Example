package exercise26;

import java.util.ArrayList;

public class EvenDigitChecker {

	public boolean evenDigitsOnly(int n) {
		boolean answer = true;
		ArrayList<Integer> holder = createArrayList(n);
		
		for (int i = 0; i <holder.size(); i++) {
			if (holder.get(i) % 2 != 0) {
				answer = false;
				break;
			}
		}
		
		return answer;
	}

	public ArrayList<Integer> createArrayList(int input) {
		int temp = input;

		ArrayList<Integer> createArray = new ArrayList<>();
		do {
			createArray.add(0, temp % 10);
			temp /= 10;
		} while (temp > 0);

		return createArray;
	}
}
